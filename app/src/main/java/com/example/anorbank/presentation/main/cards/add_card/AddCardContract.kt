package com.example.anorbank.presentation.main.cards.add_card

import org.orbitmvi.orbit.ContainerHost

interface AddCardContract {

    sealed interface Model : ContainerHost<UiState, SideEffect>{
        fun onEventDispatcher(intent: MyIntent)
    }

    sealed interface UiState{
        data object InitState: UiState
    }


    sealed interface SideEffect{}


    sealed interface MyIntent{
        data class AddCardData(
            val pan: String,
            val expireYear: String,
            val expireMoth: String,
            val name: String
        ): MyIntent
    }

}