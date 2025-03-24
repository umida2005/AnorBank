package com.example.anorbank.presentation.main.monitoring

import com.example.anorbank.data.model.remote.response.card_response.GetCardResponse
import com.example.anorbank.data.model.remote.response.historyResponse.Child
import com.example.anorbank.presentation.main.home.MainContract
import org.orbitmvi.orbit.ContainerHost

interface MonitoringContract {

    sealed interface Model:ContainerHost<UiState, SideEffect>{
        fun onEventDispatcher(intent: MyIntent)
        }

//    sealed interface UiState{
//        data object InitState: UiState
//        data class HistoryChild(val history: List<Child>): UiState
//    }
data class UiState(
    val historyList: ArrayList<Child> = ArrayList(),
    )

    sealed interface SideEffect{
        data class Toast(val message:String): SideEffect
    }

    sealed interface MyIntent{
        data object Intent: MyIntent
    }
}
