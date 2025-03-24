package com.example.anorbank.presentation.auth.keyword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject


@HiltViewModel
class KeywordModel  @Inject constructor(private val direction: KeywordDirection) : ViewModel(), KeywordContract.Model{
    override fun onEventDispatcher(intent: KeywordContract.MyIntent) {
        when(intent){
            is KeywordContract.MyIntent.NextMain ->{
                viewModelScope.launch {
                    direction.nextMain()
                }
            }
        }
    }


    override val container=container<KeywordContract.UIState, KeywordContract.SideEffect>(KeywordContract.UIState.InitState)

}