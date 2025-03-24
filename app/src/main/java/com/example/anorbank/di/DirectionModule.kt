package com.example.anorbank.di

import com.example.anorbank.presentation.auth.finger.FingerDirection
import com.example.anorbank.presentation.auth.finger.FingerDirectionImpl
import com.example.anorbank.presentation.auth.keyword.KeywordDirection
import com.example.anorbank.presentation.auth.keyword.KeywordDirectionImpl
import com.example.anorbank.presentation.auth.language.LanguageDirection
import com.example.anorbank.presentation.auth.language.LanguageDirectionImpl
import com.example.anorbank.presentation.auth.pincode.PinCodeContract
import com.example.anorbank.presentation.auth.pincode.PinCodeDirection
import com.example.anorbank.presentation.auth.register.phone.AuthDirection
import com.example.anorbank.presentation.auth.register.phone.AuthDirectionImpl
import com.example.anorbank.presentation.auth.register.reg.RegDirection
import com.example.anorbank.presentation.auth.register.reg.RegDirectionImpl
import com.example.anorbank.presentation.auth.verify.SmsDirection
import com.example.anorbank.presentation.auth.verify.SmsDirectionImpl
import com.example.anorbank.presentation.auth.verify.vaerifyLog.SmsLogDirection
import com.example.anorbank.presentation.auth.verify.vaerifyLog.SmsLogDirectionImpl
import com.example.anorbank.presentation.main.cards.CardDirection
import com.example.anorbank.presentation.main.cards.CardDirectionImpl
import com.example.anorbank.presentation.main.cards.add_card.AddCardDirection
import com.example.anorbank.presentation.main.cards.add_card.AddCardDirectionImpl
import com.example.anorbank.presentation.main.home.MainDirection
import com.example.anorbank.presentation.main.home.MainDirectionImpl
import com.example.anorbank.presentation.main.monitoring.MonitoringDirection
import com.example.anorbank.presentation.main.monitoring.MonitoringDirectionImpl
import com.example.anorbank.presentation.main.payment.PaymentDirection
import com.example.anorbank.presentation.main.payment.PaymentDirectionImpl
import com.example.anorbank.presentation.main.payment.otp_transfer.OtpTransferDirection
import com.example.anorbank.presentation.main.payment.otp_transfer.OtpTransferDirectionImpl
import com.example.anorbank.presentation.main.payment.transaction.TransactionDirection
import com.example.anorbank.presentation.main.payment.transaction.TransactionDirectionImpl
import com.example.anorbank.presentation.main.payment.transfer_success.SuccessDirection
import com.example.anorbank.presentation.main.payment.transfer_success.SuccessDirectionImpl
import com.example.anorbank.presentation.splash.SplashDirection
import com.example.anorbank.presentation.splash.SplashDirectionImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface DirectionModule {
    @Binds
    fun splashDirection(impl: SplashDirectionImpl): SplashDirection

    @Binds
    fun languageDir(impl: LanguageDirectionImpl): LanguageDirection

    @Binds
    fun authPhoneDir(impl: AuthDirectionImpl): AuthDirection

    @Binds
    fun regDirection(impl: RegDirectionImpl): RegDirection

    @Binds
    fun smsCodeDir(impl: SmsDirectionImpl): SmsDirection

    @Binds
    fun smsLogDirection(impl: SmsLogDirectionImpl): SmsLogDirection

    @Binds
    fun fingerDir(impl: FingerDirectionImpl): FingerDirection

    @Binds
    fun keywordDir(impl: KeywordDirectionImpl): KeywordDirection


    @Binds
    fun mainDir(impl: MainDirectionImpl): MainDirection


    @Binds
    fun addCardDir(impl: AddCardDirectionImpl): AddCardDirection

    @Binds
    fun transactionDir(impl: TransactionDirectionImpl): TransactionDirection

    @Binds
    fun paymentDir(impl: PaymentDirectionImpl): PaymentDirection

    @Binds
    fun otpTransfer(impl: OtpTransferDirectionImpl): OtpTransferDirection

    @Binds
    fun historyDir(impl: MonitoringDirectionImpl): MonitoringDirection

    @Binds
    fun cardDir(impl: CardDirectionImpl): CardDirection

    @Binds
    fun successDir(impl: SuccessDirectionImpl):SuccessDirection

    @Binds
    fun pinnedDir(impl: PinCodeDirection): PinCodeContract.Direction


}