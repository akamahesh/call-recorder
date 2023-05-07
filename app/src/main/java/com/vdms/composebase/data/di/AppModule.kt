package com.vdms.composebase.data.di

import android.content.Context
import androidx.compose.runtime.Stable
import com.vdms.composebase.CallRecordingVDMSApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by merttoptas on 25.03.2022
 */

@Stable
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): CallRecordingVDMSApp {
        return app as CallRecordingVDMSApp
    }
}