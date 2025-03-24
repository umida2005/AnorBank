package com.example.anorbank.presentation.main.payment.transfer_success

import com.example.anorbank.presentation.main.bottom.MyBottomNavigation
import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface SuccessDirection {
    suspend fun backToMain()
}

@Singleton
class SuccessDirectionImpl @Inject constructor(val navigator: AppNavigator):SuccessDirection{
    override suspend fun backToMain() {
        navigator.replace(MyBottomNavigation())
    }

}