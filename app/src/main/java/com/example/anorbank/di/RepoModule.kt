package com.example.anorbank.di

import com.example.anorbank.domain.Repo
import com.example.anorbank.domain.impl.RepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {
    @Binds
    fun bindRepo(impl: RepoImpl): Repo
}