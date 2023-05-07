package com.vdms.composebase.data.remote.source

import com.vdms.composebase.data.model.EpisodesResponse
import com.vdms.composebase.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow

/**
 * Created by merttoptas on 19.03.2022
 */

interface EpisodesRemoteDataSource {
    suspend fun getAllEpisodes(): Flow<DataState<EpisodesResponse>>
    suspend fun getEpisode(episodeId: Int): Flow<DataState<EpisodesResponse>>
}