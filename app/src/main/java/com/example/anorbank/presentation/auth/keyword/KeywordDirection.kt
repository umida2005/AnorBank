    package com.example.anorbank.presentation.auth.keyword

import com.example.anorbank.presentation.main.bottom.MyBottomNavigation
import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface KeywordDirection {
    suspend fun nextMain()
}


@Singleton
class KeywordDirectionImpl @Inject constructor(private val appNavigator: AppNavigator): KeywordDirection{
    override suspend fun nextMain() {
        appNavigator.replace(MyBottomNavigation())
    }


}