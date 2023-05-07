package com.vdms.composebase.data.di

import androidx.compose.runtime.Stable
import com.vdms.composebase.data.remote.api.EpisodesService
import com.vdms.composebase.data.remote.source.EpisodesRemoteDataSource
import com.vdms.composebase.data.remote.source.impl.EpisodesRemoteDataSourceImpl
import com.vdms.composebase.data.repository.EpisodesRepositoryImpl
import com.vdms.composebase.domain.repository.EpisodesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

/**
 * Created by merttoptas on 19.03.2022
 */
@Stable
@Module
@InstallIn(ViewModelComponent::class)
class EpisodesModule {
    @Provides
    fun provideEpisodesService(retrofit: Retrofit): EpisodesService =
        retrofit.create(EpisodesService::class.java)

    @Provides
    fun provideEpisodesRemoteDataSource(episodesService: EpisodesService): EpisodesRemoteDataSource =
        EpisodesRemoteDataSourceImpl(episodesService)

    @Provides
    fun provideEpisodesRepository(
        episodesRemoteDataSource: EpisodesRemoteDataSource
    ): EpisodesRepository =
        EpisodesRepositoryImpl(episodesRemoteDataSource)
}