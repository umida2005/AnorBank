package com.example.anorbank.presentation.main.payment.otp_transfer

import org.orbitmvi.orbit.ContainerHost

interface OtpTransferContract {
    sealed interface Model: ContainerHost<UiState, SideEffect>{
        fun onEventDispatcher(intent: MyIntent)
    }

    sealed interface UiState{

        data object InitState: UiState
    }
    sealed interface SideEffect{}

    sealed interface MyIntent{
        data class OtpVerifyData( val otp: String): MyIntent
    }



}