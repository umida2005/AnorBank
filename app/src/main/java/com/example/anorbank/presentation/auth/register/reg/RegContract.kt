package com.example.anorbank.presentation.auth.register.reg

import org.orbitmvi.orbit.ContainerHost

sealed interface RegContract {

    sealed interface Model : ContainerHost<UIState, SideEffect> {

        fun onEventDispatcher(intent: MyIntent)
    }

    sealed interface UIState {
        data object InitState : UIState
    }

    sealed interface SideEffect {}

    sealed interface MyIntent {
        data class Register(
            val phone: String,
            val password: String,
            val firstName: String,
            val lastName: String,
            val bornDate: String,
            val gender: String
        ) : MyIntent

        data object NextScreen : MyIntent
    }
}