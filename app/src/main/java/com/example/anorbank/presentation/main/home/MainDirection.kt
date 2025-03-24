package com.example.anorbank.presentation.main.home

import com.example.anorbank.presentation.main.cards.add_card.AddCardScreen
import com.example.anorbank.presentation.profile.ProfileScreen
import com.example.anorbank.utils.navigator.AppNavigator
import com.example.anorbank.zed.expendables.home_ex.AddCards
import javax.inject.Inject
import javax.inject.Singleton

interface MainDirection {
    suspend fun openProfile()
    suspend fun openAddCard()
}
@Singleton
class MainDirectionImpl @Inject constructor(private val appNavigator: AppNavigator) : MainDirection{
    override suspend fun openProfile() {
        appNavigator.navigateTo(ProfileScreen())
    }

    override suspend fun openAddCard() {
        appNavigator.navigateTo(AddCardScreen())
    }

}