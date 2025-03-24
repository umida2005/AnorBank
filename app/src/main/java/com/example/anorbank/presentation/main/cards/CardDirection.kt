package com.example.anorbank.presentation.main.cards

import com.example.anorbank.presentation.main.cards.add_card.AddCardScreen
import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface CardDirection {
    suspend fun openAddCard()
}

@Singleton
class CardDirectionImpl @Inject constructor(val navigator: AppNavigator): CardDirection{
    override suspend fun openAddCard() {
        navigator.navigateTo(AddCardScreen())
    }

}