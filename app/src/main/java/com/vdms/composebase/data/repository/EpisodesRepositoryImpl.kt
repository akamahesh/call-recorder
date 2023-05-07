package com.vdms.composebase.data.repository

import com.vdms.composebase.data.model.EpisodesResponse
import com.vdms.composebase.data.remote.source.EpisodesRemoteDataSource
import com.vdms.composebase.data.remote.utils.DataState
import com.vdms.composebase.domain.repository.EpisodesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by merttoptas on 19.03.2022
 */

class EpisodesRepositoryImpl @Inject constructor(private val episodesRemoteDataSource: EpisodesRemoteDataSource) :
    EpisodesRepository {

    override fun getAllEpisodes(): Flow<DataState<EpisodesResponse>> = flow {
        emitAll(episodesRemoteDataSource.getAllEpisodes())
    }

    override fun getEpisode(episodeId: Int): Flow<DataState<EpisodesResponse>> = flow {
        emitAll(episodesRemoteDataSource.getEpisode(episodeId))
    }
}