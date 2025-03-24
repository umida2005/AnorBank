package com.example.anorbank.presentation.main.payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject


@HiltViewModel
class PaymentModel @Inject constructor(val direction: PaymentDirection) : PaymentContract.Model, ViewModel(){
    override fun onEventDispatcher(intent: PaymentContract.MyIntent) {
      when(intent){
          is PaymentContract.MyIntent.openTransfer ->{
              viewModelScope.launch {
                  direction.nextTransfer()
              }
          }
      }
    }

    override val container = container<PaymentContract.UiState, PaymentContract.SideEffect>(PaymentContract.UiState.EmptyState)



}