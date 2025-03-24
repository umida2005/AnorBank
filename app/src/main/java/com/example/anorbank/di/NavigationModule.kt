package com.example.anorbank.di

import com.example.anorbank.utils.navigator.AppNavigator
import com.example.anorbank.utils.navigator.NavigationDispatcher
import com.example.anorbank.utils.navigator.NavigationHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)

interface NavigationModule {

    @Binds
    fun bindAppNavigator(impl: NavigationDispatcher): AppNavigator

    @Binds
    fun bindNavigationHandler(impl: NavigationDispatcher): NavigationHandler


}