package com.example.anorbank.presentation.auth.verify

import android.content.Context
import com.example.anorbank.presentation.auth.finger.FingerScreen
import com.example.anorbank.presentation.auth.pin.PinCode
import com.example.anorbank.presentation.auth.pin.PinScreen
import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface SmsDirection {
    suspend fun nextFinger()
}

@Singleton
class SmsDirectionImpl
@Inject constructor(private val appNavigator:AppNavigator,): SmsDirection{
    override suspend fun nextFinger() {
        appNavigator.replace(FingerScreen())
    }
}