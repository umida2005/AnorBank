package com.example.anorbank.presentation.auth.verify

import org.orbitmvi.orbit.ContainerHost

sealed interface SmsContract {


    sealed interface Model: ContainerHost<UIState, SideEffect>{
        fun onEventDispatcher(intent: MyIntent)
    }

    sealed interface UIState{
        data object InitState: UIState
    }

    sealed interface  SideEffect{}


    sealed interface MyIntent{
        data object NextPinCode: MyIntent
        data class OtpIntent( val otp: String): MyIntent
    }


}