package com.example.anorbank.presentation.auth.register.phone

import android.net.wifi.WifiManager.SubsystemRestartTrackingCallback
import org.orbitmvi.orbit.ContainerHost

sealed interface AuthContract {

    sealed interface Model : ContainerHost<UIState, SideEffect> {
        fun onEventDispatcher(intent: MyIntent)
    }

    sealed interface UIState {
        data object InitState : UIState
    }

    sealed interface SideEffect {}




    sealed interface MyIntent {
        data object RegScreen : MyIntent
        data class LoginToSms(val phone: String, val password: String): MyIntent
    }
}