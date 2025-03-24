package com.example.anorbank.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NetworkStatusValidator
@Inject constructor(@ApplicationContext val context: Context) {

    var hasNetwork: Boolean = false

    @SuppressLint("SuspiciousIndentation")
    fun init(availableNetworkBlock:()->Unit, lostConnect:()->Unit){
        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()

        val connectivityCallBack =object :ConnectivityManager.NetworkCallback(){
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                hasNetwork = true
                availableNetworkBlock.invoke()
            }


            override fun onLost(network: Network) {
                super.onLost(network)
                lostConnect.invoke()
                hasNetwork = false
            }
        }

        val connectivityManager  = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.requestNetwork(networkRequest, connectivityCallBack)
    }
}