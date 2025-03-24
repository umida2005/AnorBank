package com.example.anorbank.presentation.main.cards.add_card

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anorbank.data.model.remote.request.card_requests.AddCardRequest
import com.example.anorbank.domain.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject


@HiltViewModel
class AddCardModel @Inject constructor(private val direction: AddCardDirection, val repo: Repo) :
    ViewModel(),
    AddCardContract.Model {
    override fun onEventDispatcher(intent: AddCardContract.MyIntent) = intent {
        when (intent) {
            is AddCardContract.MyIntent.AddCardData -> {

                repo.addCard(
                    AddCardRequest(
                        pan = intent.pan,
                        expiredYear = intent.expireYear,
                        expiredMonth = intent.expireMoth,
                        name = intent.name
                    )
                ).onEach {
                    it.onSuccess {
                        direction.BackToHome()
                    }
                    it.onFailure {

                    }
                }.launchIn(viewModelScope)

            }

        }
    }

    override val container =
        container<AddCardContract.UiState, AddCardContract.SideEffect>(AddCardContract.UiState.InitState)

}