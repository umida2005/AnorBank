package com.example.anorbank.presentation.auth.register.reg

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anorbank.data.model.remote.request.auth_requests.UserRegisterRequest
import com.example.anorbank.domain.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class RegModel @Inject constructor(private val direction: RegDirection, private val repo: Repo): ViewModel(), RegContract.Model{
    override fun onEventDispatcher(intent: RegContract.MyIntent) {
        when(intent){
            is RegContract.MyIntent.Register ->{
                repo.registration(
                    UserRegisterRequest(
                    phone = intent.phone,
                    password = intent.password,
                    firstName =intent.firstName,
                    lastName = intent.lastName,
                    bornDate = intent.bornDate,
                    gender = intent.gender
                )
                )
                    .onEach {
                        it.onSuccess {
                           direction.nextVerifySmsScreen()
                        }
                        it.onFailure {

                        }
                    }.launchIn(viewModelScope)
            }

            else -> {

            }
        }
    }

    override val container = container<RegContract.UIState, RegContract.SideEffect>(RegContract.UIState.InitState)

}