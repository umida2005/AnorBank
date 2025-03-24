//package com.example.anorbank.di
//
//import android.content.Context
//import androidx.room.Room
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//class DBModule {
//    @[Provides Singleton]
//    fun provideAppDatabase(@ApplicationContext context: Context):AppDatabase=
//        Room.databaseBuilder(context, AppDatabase::class.java, "CardContact.db")
//            .allowMainThreadQueries()
//            .build()
//}