package com.example.anorbank.presentation.auth.register.reg

import com.example.anorbank.presentation.auth.pin.PinScreen
import com.example.anorbank.presentation.auth.verify.SmsScreen
import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface RegDirection {
suspend  fun nextVerifySmsScreen()
}

@Singleton
class RegDirectionImpl
@Inject
constructor(private val appNavigator: AppNavigator):RegDirection{
    override suspend fun nextVerifySmsScreen() {
        appNavigator.replace(SmsScreen())
    }


}