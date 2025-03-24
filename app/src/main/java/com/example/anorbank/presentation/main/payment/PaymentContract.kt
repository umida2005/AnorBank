package com.example.anorbank.presentation.main.payment

import com.example.anorbank.presentation.main.home.MainContract
import org.orbitmvi.orbit.ContainerHost

interface PaymentContract {
    sealed interface Model :ContainerHost<UiState, SideEffect>{
        fun onEventDispatcher(intent: MyIntent)
    }

    sealed interface UiState{
        data object  EmptyState:UiState
    }

    sealed interface SideEffect{}

    sealed interface MyIntent{
        data object openTransfer: MyIntent

    }
}