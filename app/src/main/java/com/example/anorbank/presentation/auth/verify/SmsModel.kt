package com.example.anorbank.presentation.auth.verify

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
class SmsModel @Inject constructor(private val direction: SmsDirection, val repo: Repo, val shared: MyPreference) : ViewModel(),
    SmsContract.Model {
    override fun onEventDispatcher(intent: SmsContract.MyIntent) {
        when (intent) {
            is SmsContract.MyIntent.OtpIntent ->
              repo.otpVerifySignUp(OtpRequest(token = shared.getToken(), smsCode = intent.otp))
                  .onEach {
                       it.onSuccess {
                            direction.nextFinger()
                      }
                      it.onFailure {

                      }
                  }.launchIn(viewModelScope)

            else -> {

            }
        }

    }


    override val container =
        container<SmsContract.UIState, SmsContract.SideEffect>(SmsContract.UIState.InitState)

}