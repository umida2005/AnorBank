package com.example.anorbank.presentation.auth.finger

import com.example.anorbank.presentation.auth.language.LanguageContract
import com.example.anorbank.presentation.auth.verify.SmsContract
import org.orbitmvi.orbit.ContainerHost

sealed interface FingerContract {

    sealed interface Model : ContainerHost<UIState, SideEffect>{
        fun onEventDispatcher(intent: MyIntent)
    }


    sealed interface UIState{
        data object InitState : UIState
    }

    sealed interface SideEffect{}


    sealed interface MyIntent{
        data object  NextKeywordScreen: MyIntent
    }
}