package com.example.anorbank.presentation.main.cards.add_card

import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface AddCardDirection {
    suspend fun BackToHome()
}

@Singleton
class AddCardDirectionImpl  @Inject constructor(private val navigator: AppNavigator): AddCardDirection{
    override suspend fun BackToHome() {
            navigator.back()
    }

}