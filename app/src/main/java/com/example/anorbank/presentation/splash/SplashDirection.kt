package com.example.anorbank.presentation.splash

import com.example.anorbank.data.source.local.MyPreference
import com.example.anorbank.presentation.auth.language.LanguageScreen
import com.example.anorbank.presentation.auth.pincode.PinCodeScreen
import com.example.anorbank.presentation.auth.register.phone.AuthScreen
import com.example.anorbank.presentation.main.bottom.MyBottomNavigation
import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface SplashDirection {


    suspend fun OpenNext()


}

@Singleton
class SplashDirectionImpl @Inject constructor(
    private val  appNavigator: AppNavigator, private val shared: MyPreference):
    SplashDirection{


    override suspend fun OpenNext() {
        val isFirstInstall = shared.getSelectedLanguage()
        val token = shared.getToken()

        if(isFirstInstall.isEmpty() || isFirstInstall == null){
            appNavigator.replace(LanguageScreen())
        }else if(token.isEmpty() || token =="" || token ==null){
            appNavigator.replace(AuthScreen())
        }else{
            appNavigator.replace(PinCodeScreen())
        }

    }

}