package com.example.anorbank.presentation.main.home

import com.example.anorbank.data.model.remote.response.card_response.GetCardResponse
import com.example.anorbank.presentation.main.payment.transaction.TransactionContract
import org.orbitmvi.orbit.ContainerHost

interface MainContract {
        sealed interface  Model: ContainerHost<UiState, SideEffect>{
            fun  onEventDispatcher(intent: MyIntent)
        }

    sealed interface UiState{
        data object  EmptyState: UiState
        data class CardLists(val cards: List<GetCardResponse>): UiState

        data class MyList(val cards: List<GetCardResponse>):UiState
    }

    sealed interface SideEffect{
        data class Toast(val message:String):SideEffect
    }

    sealed interface   MyIntent{
        data object   OpenProfile: MyIntent
            data object OpenAddCard : MyIntent
        data class MyCard(val list:ArrayList<GetCardResponse>)
    }
}