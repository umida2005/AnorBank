package com.example.anorbank.presentation.main.payment.otp_transfer

import com.example.anorbank.presentation.main.payment.transfer_success.SuccessTransferScreen
import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface OtpTransferDirection {
   suspend fun openSuccessTransferScreen()
}

@Singleton
class OtpTransferDirectionImpl @Inject constructor(val appNavigator: AppNavigator): OtpTransferDirection{
    override suspend fun openSuccessTransferScreen() {
        appNavigator.replace(SuccessTransferScreen())
    }
}