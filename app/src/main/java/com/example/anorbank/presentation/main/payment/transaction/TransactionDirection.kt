package com.example.anorbank.presentation.main.payment.transaction

import com.example.anorbank.presentation.main.payment.otp_transfer.OtpTransferScreen
import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface TransactionDirection {
    suspend fun nextToVerify()
}


@Singleton
class TransactionDirectionImpl @Inject constructor(private val navigator: AppNavigator) :
    TransactionDirection {
    override suspend fun nextToVerify() {
        navigator.replace(OtpTransferScreen())
    }

}