package com.example.anorbank.presentation.auth.pincode

import com.example.anorbank.presentation.main.bottom.MyBottomNavigation
import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject

class PinCodeDirection @Inject constructor(private val appNavigator: AppNavigator):PinCodeContract.Direction {



    override suspend fun openManiScreen() {
        appNavigator.replace(MyBottomNavigation())
    }


}