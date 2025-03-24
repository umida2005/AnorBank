package com.example.anorbank.presentation.main.payment.transfer_success

import com.example.anorbank.presentation.splash.SplashContract
import org.orbitmvi.orbit.ContainerHost

interface SuccessContract {

    sealed interface Model:ContainerHost<UiState, SideEffect>{
        fun onEventDispatcher(intent: MyIntent)

        fun extra(): AllData
        data class AllData(
            val senderName: String,
            val senderPan: String,
            val receiverName: String,
            val receiverPan: String,
            val totalAmount: String,

        )
    }

    sealed interface UiState{
        data object InitState: UiState
    }
    sealed interface SideEffect{

    }

    sealed interface MyIntent{
        data object Intent: MyIntent
    }
}