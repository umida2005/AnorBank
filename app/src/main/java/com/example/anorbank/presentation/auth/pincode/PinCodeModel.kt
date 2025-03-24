package com.example.anorbank.presentation.auth.pincode

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.anorbank.data.source.local.MyPreference
import com.example.anorbank.utils.NetworkStatusValidator

import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class PinCodeViewModel @Inject constructor(
    private val direction: PinCodeDirection,
    private val mySharedPreference: MyPreference,
    private val networkStatusValidator: NetworkStatusValidator
) : PinCodeContract.ViewModel,
    ViewModel() {
    @SuppressLint("LogNotTimber")
    override fun onEventDispatcher(intent: PinCodeContract.Intent) = intent {
        when (intent) {
            is PinCodeContract.Intent.OpenMainScreen -> {
//                direction.openManiScreen {
//
//                }
                Log.d("SSS", "${mySharedPreference.getPinCOde()}+" + "${intent.code}")

                Log.d("SSS", "${mySharedPreference.getPinCOde()}")
                if (mySharedPreference.getPinCOde() == "") {
                    mySharedPreference.setPinCode(intent.code)
                    postSideEffect(PinCodeContract.SideEffect.IsFUl(true))

                }else{
                    if (mySharedPreference.getPinCOde()==intent.code){
                        direction.openManiScreen ()
                    }
                }


            }
            is  PinCodeContract.Intent.OpenMainScreen1->{
                if (mySharedPreference.getPinCOde()==intent.code){
                }
            }
        }
    }

    override val container = container<PinCodeContract.UIState, PinCodeContract.SideEffect>(
        PinCodeContract.UIState.Massage("error")
    )
}