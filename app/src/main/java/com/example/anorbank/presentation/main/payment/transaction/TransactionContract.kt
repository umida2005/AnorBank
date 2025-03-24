package com.example.anorbank.presentation.main.payment.transaction

import com.example.anorbank.data.model.remote.response.card_response.GetCardResponse
import com.example.anorbank.data.source.dataUI.GetReceiverCardData
import org.orbitmvi.orbit.ContainerHost

interface TransactionContract {

    sealed interface Model : ContainerHost<UiState, SideEffect> {
        fun onEventDispatcher(intent: MyIntent)

    }

    data class UiState(

        val cardList: ArrayList<GetCardResponse> = ArrayList(),
        val card: GetReceiverCardData = GetReceiverCardData(""),
        var state: Boolean = false

    )

    sealed interface SideEffect {
        data class Toast(val message: String) : SideEffect
    }

    sealed interface MyIntent {
        data object OpenVerifyOtp : MyIntent

        data class Data(val senderName: String, val senderPan: String):MyIntent
        data class GetReceiver(val card: GetReceiverCardData) : MyIntent
        data class TransferMoney(
            val type: String,
            val senderId: String,
            val receiverPan: String,
            val amount: Int
        ): MyIntent

    }
}