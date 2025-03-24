package com.example.anorbank.presentation.auth.finger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anorbank.utils.navigator.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject
import javax.inject.Singleton


@HiltViewModel


class FingerModel @Inject constructor(private val direction: FingerDirection) : ViewModel(), FingerContract.Model {
    override fun onEventDispatcher(intent: FingerContract.MyIntent) {
        viewModelScope.launch {
            direction.nextKeyWord()
        }
    }

    override val container = container<FingerContract.UIState, FingerContract.SideEffect>(FingerContract.UIState.InitState)

}