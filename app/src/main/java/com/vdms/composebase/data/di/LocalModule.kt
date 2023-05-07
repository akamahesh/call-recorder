package com.vdms.composebase.data.di

import android.content.Context
import androidx.compose.runtime.Stable
import com.vdms.composebase.data.local.dao.FavoriteDao
import com.vdms.composebase.data.local.db.RickAndMortyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by merttoptas on 27.03.2022
 */
@Stable
@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    fun provideRickAndMortyDatabase(
        @ApplicationContext context: Context
    ): RickAndMortyDatabase {
        return RickAndMortyDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideFavoriteDao(appDatabase: RickAndMortyDatabase): FavoriteDao {
        return appDatabase.favoriteDao()
    }
}