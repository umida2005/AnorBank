package com.example.anorbank.presentation.main.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anorbank.data.model.remote.response.card_response.GetCardResponse
import com.example.anorbank.domain.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainModel @Inject constructor(private val direction: MainDirection, val repo: Repo) :
    ViewModel(),
    MainContract.Model {

    val list = ArrayList<GetCardResponse>()


//    init {
//        loadAllCards()
//     }

    override fun onEventDispatcher(intent: MainContract.MyIntent) = intent {
        when (intent) {
            is MainContract.MyIntent.OpenProfile -> {
                direction.openProfile()
            }
            else -> {
                direction.openAddCard()
            }
        }
    }

    fun loadAllCards() {
        repo.getAllCards().onEach {
            it.onSuccess {
                list.clear()
                list.addAll(it)
                Log.d("ZZZ", "${it.size} card size")
                intent {
                    reduce {
                        MainContract.UiState.CardLists(
                            cards = list
                        )
                    }
                }
            }
            it.onFailure {
                intent {
                    postSideEffect(
                        MainContract.SideEffect.Toast(
                            it.message ?: "Unknow error"
                        )
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    override val container =
        container<MainContract.UiState, MainContract.SideEffect>(MainContract.UiState.CardLists(list))

}

