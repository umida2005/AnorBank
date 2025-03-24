package com.example.anorbank.presentation.main.payment.otp_transfer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anorbank.data.model.remote.request.transfer_request.TransferVerifyRequest
import com.example.anorbank.data.source.local.MyPreference
import com.example.anorbank.domain.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject


@HiltViewModel
class OtpTransferModel @Inject constructor(private val shared: MyPreference, private val direction: OtpTransferDirection, val repo: Repo): ViewModel(), OtpTransferContract.Model {
    override fun onEventDispatcher(intent: OtpTransferContract.MyIntent) {

        when(intent){
           is OtpTransferContract.MyIntent.OtpVerifyData->{
               repo.transferVerify(
                   TransferVerifyRequest(
                       token = shared.getTransferToken(),
                       code = intent.otp
                   )

               ).onEach {
                   it.onSuccess {
                       direction.openSuccessTransferScreen()
                   }
                   it.onFailure {  }
               }.launchIn(viewModelScope)
           }
        }
    }

    override val container=container<OtpTransferContract.UiState,
            OtpTransferContract.SideEffect>(OtpTransferContract.UiState.InitState)

}