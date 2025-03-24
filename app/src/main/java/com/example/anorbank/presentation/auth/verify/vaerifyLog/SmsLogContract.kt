package com.example.anorbank.presentation.auth.verify.vaerifyLog

import org.orbitmvi.orbit.ContainerHost

interface SmsLogContract {

    sealed interface Model: ContainerHost<UiState, SideEffect>{
        fun onEventDispatcher(intent: MyIntent)
    }

    sealed interface UiState{
        data object  InitState: UiState
    }

    sealed interface SideEffect{}

    sealed interface MyIntent{
        data class OtpIntent(val otp: String):MyIntent
    }

}