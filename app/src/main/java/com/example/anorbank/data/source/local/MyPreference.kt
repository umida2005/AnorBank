package com.example.anorbank.data.source.local

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MyPreference @Inject constructor(private val sharedPreference: SharedPreferences) {


    //auth token
 // biz qiyatlarni saqlab oladigan funksiya
    fun saveToken(token: String): Unit = sharedPreference.edit()
        .putString("TOKEN", token).apply()


    fun getToken(): String = sharedPreference.getString("TOKEN", "LOGIN")!!


    // access token
    fun saveAccessToken(token: String): Unit = sharedPreference.edit()
        .putString("ACCESS", token).apply()


    fun getAccessToken(): String = sharedPreference.getString("ACCESS", "")!!


    //transferVerifyToken
    fun saveTransferToken(token: String): Unit = sharedPreference.edit()
        .putString("TRANSFER", token).apply()


    fun getTransferToken(): String = sharedPreference.getString("TRANSFER", "")!!


    // refresh token

    fun saveRefreshToken(token: String): Unit = sharedPreference.edit()
        .putString("REFRESH", token).apply()


    fun getRefreshToken(): String = sharedPreference.getString("REFRESH", null)!!

    // pin

    fun savePinCode(pin: String) = sharedPreference.edit().putString("PIN", pin).apply()

    fun getPin(): String = sharedPreference.getString("PIN", null)!!

    //language
    fun saveLanguage(selectedLanguage: String) {
        sharedPreference.edit().putString("LANG", selectedLanguage).apply()
    }

    fun getSelectedLanguage(): String = sharedPreference.getString("LANG", "")!!


    //first installation












    fun setSenderTitle(selectedLanguage: String) {
        sharedPreference.edit().putString("SENDER_TITLE", selectedLanguage).apply()
    }

    fun getSenderTitle(): String = sharedPreference.getString("SENDER_TITLE", "")!!



    fun setSenderPan(selectedLanguage: String) {
        sharedPreference.edit().putString("SENDER_PAN", selectedLanguage).apply()
    }

    fun getSenderPan(): String = sharedPreference.getString("SENDER_PAN", "")!!








    fun setReceiverName(selectedLanguage: String) {
        sharedPreference.edit().putString("RECEIVER_NAME", selectedLanguage).apply()
    }

    fun getReceiverName(): String = sharedPreference.getString("RECEIVER_NAME", "")!!





    fun setReceiverPan(selectedLanguage: String) {
        sharedPreference.edit().putString("RECEIVER_PAN", selectedLanguage).apply()
    }

    fun getReceiverPan(): String = sharedPreference.getString("RECEIVER_PAN", "")!!



    fun setTransferAmount(selectedLanguage: String) {
        sharedPreference.edit().putString("TRANSFER_AMOUNT", selectedLanguage).apply()
    }

    fun getTransferAmount(): String = sharedPreference.getString("TRANSFER_AMOUNT", "")!!


    fun setPinCode(pinCode:String){
        sharedPreference.edit().putString("code",pinCode).apply()
    }
    fun getPinCOde(): String? =sharedPreference.getString("code","")
























}