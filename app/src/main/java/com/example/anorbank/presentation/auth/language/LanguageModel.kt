package com.example.anorbank.presentation.auth.language

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anorbank.data.source.local.MyPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject


@HiltViewModel
class LanguageModel  @Inject constructor(private val  direction: LanguageDirection,
                                         private val shared: MyPreference):
    ViewModel(), LanguageContract.Model {
    override fun onEventDispatcher(intent: LanguageContract.Intent) {
           when(intent){
             is LanguageContract.Intent.openAuthPhone->{
                 viewModelScope.launch {
                        direction.next()
                 }
             }
           }
    }

    fun selectedLanguage(lang: String){
        shared.saveLanguage(lang)
    }
    override val container= container<LanguageContract.UIState,
            LanguageContract.SideEffect>(LanguageContract.UIState.InitState)

}