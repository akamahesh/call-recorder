package com.vdms.composebase.domain.viewstate.episodes

import androidx.compose.runtime.Stable
import com.vdms.composebase.data.model.EpisodesResultResponse
import com.vdms.composebase.domain.viewstate.IViewState

/**
 * Created by merttoptas on 19.03.2022
 */

@Stable
data class EpisodesViewState(
    val isLoading: Boolean = false,
    val data: List<EpisodesResultResponse>? = null
) : IViewState