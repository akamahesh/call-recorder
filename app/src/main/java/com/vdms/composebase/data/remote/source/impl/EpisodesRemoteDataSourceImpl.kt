package com.vdms.composebase.data.remote.source.impl

import com.vdms.composebase.data.model.EpisodesResponse
import com.vdms.composebase.data.remote.api.EpisodesService
import com.vdms.composebase.data.remote.source.EpisodesRemoteDataSource
import com.vdms.composebase.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by merttoptas on 19.03.2022
 */

class EpisodesRemoteDataSourceImpl @Inject constructor(private val episodesService: EpisodesService) :
    BaseRemoteDataSource(), EpisodesRemoteDataSource {

    override suspend fun getAllEpisodes(): Flow<DataState<EpisodesResponse>> = getResult {
        episodesService.getAllEpisodes()
    }

    override suspend fun getEpisode(episodeId: Int): Flow<DataState<EpisodesResponse>> = getResult {
        episodesService.getEpisode(episodeId = episodeId)
    }
}
