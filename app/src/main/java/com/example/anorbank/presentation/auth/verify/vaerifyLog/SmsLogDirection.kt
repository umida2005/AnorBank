package com.example.anorbank.presentation.auth.verify.vaerifyLog

import com.example.anorbank.presentation.auth.finger.FingerScreen
import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject

interface SmsLogDirection {
    suspend fun nextFinger()
}

class SmsLogDirectionImpl @Inject constructor(private val appNavigator: AppNavigator) : SmsLogDirection{
    override suspend fun nextFinger() {
        appNavigator.replace(FingerScreen())
    }
}