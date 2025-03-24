package com.example.anorbank.di

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import android.content.Context
import com.example.anorbank.utils.navigator.AppScreen
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.coroutines.coroutineContext


@Module
@InstallIn(SingletonComponent::class)
class PreffModule {

    @[Provides Singleton]
       fun providePref(@ApplicationContext context: Context):
            SharedPreferences = context.getSharedPreferences("prefferences", Context.MODE_PRIVATE)

}