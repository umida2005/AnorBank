package com.example.anorbank.presentation.splash

import org.orbitmvi.orbit.ContainerHost

sealed interface SplashContract {
 // bu faqat appRepo bn ishalydi


   sealed interface Model: ContainerHost<UIState, SideEffect>{
        fun onEventDispatcher(intent: Intent)
   }


    sealed interface UIState {
        data object InitSate : UIState
    }


    //side effectlar bu UI da doimiy mavjud bolmagan componentalar
    sealed interface SideEffect {}



    //screendan boshqasiga o'tishda, ma'umotlar olib o'tishda

    sealed interface Intent {
        data object NextScreen : Intent
    }
}