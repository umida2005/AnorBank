package com.example.anorbank.presentation.auth.verify.vaerifyLog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anorbank.data.model.remote.request.token_requests.OtpRequest
import com.example.anorbank.data.source.local.MyPreference
import com.example.anorbank.domain.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject


@HiltViewModel
class SmsLogModel @Inject constructor( private val dir: SmsLogDirection,
                                       val repo: Repo,
                                       val shared: MyPreference): ViewModel(), SmsLogContract.Model{
    override fun onEventDispatcher(intent: SmsLogContract.MyIntent) {

        when(intent){
            is SmsLogContract.MyIntent.OtpIntent ->{
                repo.otpVerifySignIn(OtpRequest(token = shared.getToken(), smsCode = intent.otp))
                    .onEach {
                            it.onSuccess {
                                dir.nextFinger()
                            }
                        it.onFailure {

                        }
                    }.launchIn(viewModelScope)

            }


        }



    }

    override val container= container<SmsLogContract.UiState, SmsLogContract.SideEffect>(SmsLogContract.UiState.InitState)


}