package com.example.anorbank.presentation.auth.keyword

import org.orbitmvi.orbit.ContainerHost

sealed interface KeywordContract {
    sealed interface Model: ContainerHost<UIState, SideEffect>{
        fun onEventDispatcher(intent: MyIntent)
    }

    sealed interface SideEffect{}


    sealed interface UIState{
        data object InitState: UIState
    }

    sealed interface MyIntent{
        data object NextMain: MyIntent
    }

}