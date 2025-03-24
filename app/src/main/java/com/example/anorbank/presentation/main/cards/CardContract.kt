package com.example.anorbank.presentation.main.cards

import com.example.anorbank.data.model.remote.response.card_response.GetCardResponse
import com.example.anorbank.data.source.dataUI.GetReceiverCardData
import com.example.anorbank.presentation.main.payment.transaction.TransactionContract
import org.orbitmvi.orbit.ContainerHost

interface CardContract {
    sealed interface  Model: ContainerHost<UiState, SideEffect>{
        fun onEventDispatcher(intent: MyIntent)
    }
    data class UiState(

        val myCardList: ArrayList<GetCardResponse> = ArrayList(),
        val card: GetReceiverCardData = GetReceiverCardData(""),
        var state: Boolean = false

    )

    sealed interface SideEffect {
        data class Toast(val message: String) : SideEffect
    }

    sealed interface MyIntent {
        data object OpenCardScreen : MyIntent



    }
}