package com.example.anorbank.presentation.auth.language

import com.example.anorbank.presentation.auth.register.phone.AuthScreen
import com.example.anorbank.presentation.auth.register.reg.RegScreen
import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface LanguageDirection {
    suspend fun next()
}


@Singleton
class LanguageDirectionImpl  @Inject constructor(private val appNavigator: AppNavigator):LanguageDirection{
    override suspend fun next() {
        appNavigator.navigateTo(AuthScreen())
    }
}