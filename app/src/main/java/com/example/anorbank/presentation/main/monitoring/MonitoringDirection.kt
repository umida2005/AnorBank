package com.example.anorbank.presentation.main.monitoring

import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface MonitoringDirection {
    suspend fun back()
}

@Singleton
class MonitoringDirectionImpl @Inject constructor(val appNavigator: AppNavigator): MonitoringDirection{
    override suspend fun back() {
        appNavigator.back()
    }
}