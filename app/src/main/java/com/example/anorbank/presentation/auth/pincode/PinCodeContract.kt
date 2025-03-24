package com.example.anorbank.presentation.auth.pincode

import org.orbitmvi.orbit.ContainerHost

sealed interface PinCodeContract {

    interface ViewModel: ContainerHost<UIState, SideEffect> {
        fun onEventDispatcher(intent:Intent)
    }

    interface UIState{
        object NotConnectionStat:UIState
        class Massage(val massage: String) : UIState
    }
    interface SideEffect{
        class Toast(massage: String):SideEffect
        class IsFUl(val isFul: Boolean) : SideEffect
    }
    interface Intent{
        class OpenMainScreen(val code: String) : Intent
        class OpenMainScreen1(val code: String) : Intent
    }
    interface Direction{
        suspend fun openManiScreen()

    }
}