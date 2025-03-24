package com.example.anorbank.presentation.main.cards

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anorbank.data.model.remote.response.card_response.GetCardResponse
import com.example.anorbank.domain.Repo
import com.example.anorbank.presentation.main.home.MainContract
import com.example.anorbank.presentation.main.payment.transaction.TransactionContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject


@HiltViewModel
class CardModel  @Inject constructor(private val repo: Repo, val direction: CardDirection): ViewModel(), CardContract.Model{
    val list = ArrayList<GetCardResponse>()

    init {
        loadAllCards()
    }
    override fun onEventDispatcher(intent: CardContract.MyIntent)=intent {
        when(intent){
            is CardContract.MyIntent.OpenCardScreen->{
               direction.openAddCard()
            }
        }
    }

    fun loadAllCards() {
        repo.getAllCards().onEach {
            it.onSuccess {
                list.clear()
                list.addAll(it)
                Log.d("ZZZ", "${it.size} card size")
                intent {
                    reduce {
                       CardContract.UiState(
                           myCardList = list
                    )
                }
            }}
            it.onFailure {
                intent {
                    postSideEffect(
                        CardContract.SideEffect.Toast(
                            it.message ?: "Unknow error"
                        )
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    override val container=container<CardContract.UiState, CardContract.SideEffect>(CardContract.UiState())

}