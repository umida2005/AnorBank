package com.example.anorbank.presentation.auth.language

import org.orbitmvi.orbit.ContainerHost

sealed interface LanguageContract {


    sealed interface Model : ContainerHost<UIState, SideEffect> {
        fun onEventDispatcher(intent: Intent)
    }


    sealed interface UIState {
        data object InitState : UIState
    }

    sealed interface SideEffect {}

    sealed interface Intent {
        data object openAuthPhone : Intent
    }
}