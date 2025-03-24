package com.example.anorbank.presentation.main.payment.transfer_success

import androidx.lifecycle.ViewModel
import com.example.anorbank.data.source.local.MyPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject


@HiltViewModel
class SuccessModel @Inject constructor(private val shared: MyPreference, val dir: SuccessDirection): ViewModel(), SuccessContract.Model{
    override fun onEventDispatcher(intent: SuccessContract.MyIntent) = intent{
        when(intent){
            is SuccessContract.MyIntent.Intent ->{
                dir.backToMain()
            }
        }
    }


    override fun extra(): SuccessContract.Model.AllData {
        return SuccessContract.Model.AllData(shared.getSenderTitle(),
            shared.getSenderPan(),
            shared.getReceiverName(), shared.getReceiverPan(),
            shared.getTransferAmount())
    }

    override val container=container<SuccessContract.UiState, SuccessContract.SideEffect>(SuccessContract.UiState.InitState)

}