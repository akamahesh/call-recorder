package com.vdms.composebase.domain.repository

import com.vdms.composebase.data.model.EpisodesResponse
import com.vdms.composebase.data.remote.utils.DataState
import kotlinx.coroutines.flow.Flow

/**
 * Created by merttoptas on 19.03.2022
 */
interface EpisodesRepository {
    fun getAllEpisodes(): Flow<DataState<EpisodesResponse>>
    fun getEpisode(episodeId: Int): Flow<DataState<EpisodesResponse>>
}