package com.example.anorbank.presentation.main.monitoring

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.anorbank.data.model.remote.response.card_response.GetCardResponse
import com.example.anorbank.data.model.remote.response.historyResponse.Child
import com.example.anorbank.data.model.remote.response.historyResponse.TransferHistory
import com.example.anorbank.domain.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject


@HiltViewModel
class MonitoringModel @Inject constructor(val repo: Repo, val dir: MonitoringDirection) :
    ViewModel(), MonitoringContract.Model {
    val list = ArrayList<Child>()
//    init {
//        loadHistory()
//    }
    override fun onEventDispatcher(intent: MonitoringContract.MyIntent) = intent{
        when(intent){
            is  MonitoringContract.MyIntent.Intent ->{
                dir.back()
            }

            MonitoringContract.MyIntent.Intent -> {}
        }
    }

    fun getHistory(size:Int, pageCount: Int): Flow<PagingData<Child>> =
        repo.getTransferHistory(size = size, currentPage = pageCount).cachedIn(viewModelScope)














//    fun loadHistory(){
//        repo.getTransferHistory().onEach {
//            it.onSuccess {
//                list.clear()
//                list.addAll(it.childList)
//                intent {
//                    reduce {
//                        MonitoringContract.UiState(
//                            historyList = list
//                        )
//                    }
//                }
//            }
//            it.onFailure {
//
//                intent {
//                    postSideEffect(MonitoringContract.SideEffect.Toast(
//                        it.message?:"No History Yet"
//                    ))
//                }
//
//            }
//        }.launchIn(viewModelScope)
//    }
    override val container =
        container<MonitoringContract.UiState, MonitoringContract.SideEffect>(MonitoringContract.UiState())

}