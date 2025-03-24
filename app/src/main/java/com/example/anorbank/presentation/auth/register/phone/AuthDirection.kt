package com.example.anorbank.presentation.auth.register.phone

import com.example.anorbank.presentation.auth.pin.PinScreen
import com.example.anorbank.presentation.auth.register.reg.RegScreen
import com.example.anorbank.presentation.auth.verify.SmsScreen
import com.example.anorbank.presentation.auth.verify.vaerifyLog.SmsLogScreen
import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface AuthDirection {
    suspend fun reg()
    suspend fun sms()
}

@Singleton
class AuthDirectionImpl @Inject constructor(private val appNavigator: AppNavigator) :
    AuthDirection {
    override suspend fun reg() {
        appNavigator.navigateTo(RegScreen())

    }

    override suspend fun sms() {
        appNavigator.navigateTo(SmsLogScreen())
    }
}