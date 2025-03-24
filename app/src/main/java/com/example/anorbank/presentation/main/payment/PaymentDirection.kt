package com.example.anorbank.presentation.main.payment

import com.example.anorbank.presentation.main.payment.transaction.TransactionScreen
import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface PaymentDirection {
    suspend fun nextTransfer()
}


@Singleton
class PaymentDirectionImpl @Inject constructor(private val navigator: AppNavigator): PaymentDirection{
    override suspend fun nextTransfer() {
        navigator.navigateTo(TransactionScreen())
    }
}