package com.example.anorbank.presentation.auth.register.phone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anorbank.data.model.remote.request.auth_requests.UserLoginRequest
import com.example.anorbank.domain.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject


@HiltViewModel
class AuthModel @Inject constructor(
    private val direction: AuthDirection,
    private val repository: Repo
) : ViewModel(), AuthContract.Model {
    override fun onEventDispatcher(intent: AuthContract.MyIntent) {
        when (intent) {
            is AuthContract.MyIntent.RegScreen -> {
                viewModelScope.launch {
                    direction.reg()
                }
            }

            is AuthContract.MyIntent.LoginToSms -> {
                repository.login(
                    UserLoginRequest(
                        intent.phone,
                        intent.password
                    )
                )
                    .onEach {
                        it.onSuccess {
                            repository.saveToken(it.token)
                            direction.sms()
                        }
                        it.onFailure {

                        }
                    }.launchIn(viewModelScope)
            }

        }
    }

    override val container =
        container<AuthContract.UIState, AuthContract.SideEffect>(AuthContract.UIState.InitState)


}