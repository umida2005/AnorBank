package com.example.anorbank.presentation.auth.finger

import com.example.anorbank.presentation.auth.keyword.KeywordScreen
import com.example.anorbank.presentation.auth.pin.PinCode
import com.example.anorbank.presentation.auth.pin.PinScreen
import com.example.anorbank.presentation.auth.pincode.PinCodeScreen
import com.example.anorbank.presentation.main.bottom.MyBottomNavigation
import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface FingerDirection {
    suspend fun nextKeyWord()
}


@Singleton
class  FingerDirectionImpl  @Inject constructor(private val annNavigator: AppNavigator): FingerDirection{
    override suspend fun nextKeyWord() {
        annNavigator.replace(PinCodeScreen())
    }
}