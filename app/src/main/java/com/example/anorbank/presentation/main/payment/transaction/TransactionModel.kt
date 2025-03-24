package com.example.anorbank.presentation.main.payment.transaction

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anorbank.data.model.remote.request.transfer_request.GetReceiverCardRequest
import com.example.anorbank.data.model.remote.request.transfer_request.TransferRequest
import com.example.anorbank.data.model.remote.response.card_response.GetCardResponse
import com.example.anorbank.data.source.dataUI.GetReceiverCardData
import com.example.anorbank.data.source.local.MyPreference
import com.example.anorbank.domain.Repo
import com.example.anorbank.presentation.main.home.MainContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject


@HiltViewModel
class   TransactionModel @Inject constructor(private val direction: TransactionDirection,
                                           val repo: Repo, val shared: MyPreference): ViewModel(), TransactionContract.Model{
    val list = ArrayList<GetCardResponse>()
    private val _uiState = MutableStateFlow(TransactionContract.UiState())
    val uiState: StateFlow<TransactionContract.UiState> = _uiState.asStateFlow()
    init {
        loadAllCards()
    }
    override fun onEventDispatcher(intent: TransactionContract.MyIntent) = intent{
        when(intent){
                is TransactionContract.MyIntent.OpenVerifyOtp->{

                }
            is TransactionContract.MyIntent.GetReceiver->{

                getReceiver(intent.card)
                shared.setReceiverPan(intent.card.pan)
            }
            is TransactionContract.MyIntent.Data->{
                shared.setSenderPan(intent.senderPan)
                shared.setSenderTitle(intent.senderName)
            }
            is TransactionContract.MyIntent.TransferMoney ->{
                repo.transfer(TransferRequest(
                    type = intent.type,
                    senderId = intent.senderId,
                    receiverPan = intent.receiverPan,
                    amount = intent.amount

                ))
                    .onEach {
                        it.onSuccess {
                            direction.nextToVerify()
                        }
                        it.onFailure {  }
                    }

                    .launchIn(viewModelScope)
                shared.setTransferAmount(intent.amount.toString())
            }
        }
    }

   private fun getReceiver(card:GetReceiverCardData){
        repo.getReceiverPan(GetReceiverCardRequest(card.pan))
            .onEach {
                it.onSuccess {data->
                    Log.d("TTT","${data.pan}")
                    intent { reduce { TransactionContract.UiState(state =true, card = GetReceiverCardData(data.pan))  } }
                }
                it.onFailure {
                    intent { reduce { TransactionContract.UiState(state =false) } }
                }
            }
            .launchIn(viewModelScope)
    }

    fun loadAllCards() {
        repo.getAllCards().onEach {
            it.onSuccess {
                list.clear()
                list.addAll(it)
                Log.d("kkk", "${it.size} card size")
                intent {
                    reduce {
                        TransactionContract.UiState(
                            cardList = list
                        )
                    }
                }
            }
            it.onFailure {
                intent {
                    postSideEffect(
                        TransactionContract.SideEffect.Toast(
                            it.message ?: "Unknow error"
                        )
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    override val container= container<TransactionContract.UiState, TransactionContract.SideEffect>(TransactionContract.UiState())


}