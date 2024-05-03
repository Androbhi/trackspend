package com.android.trackspend.di

import com.android.trackspend.repository.TrackSpendRepository
import com.android.trackspend.repository.TrackSpendRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {

    @Binds
    @ViewModelScoped
    internal abstract fun bindsImageListRepo(
        imageRepoImpl: TrackSpendRepositoryImpl
    ): TrackSpendRepository

}