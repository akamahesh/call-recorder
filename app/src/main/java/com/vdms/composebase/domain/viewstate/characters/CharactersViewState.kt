package com.vdms.composebase.domain.viewstate.characters

import androidx.compose.runtime.Stable
import androidx.paging.PagingData
import com.vdms.composebase.data.model.Result
import com.vdms.composebase.data.model.dto.CharacterDto
import com.vdms.composebase.domain.viewstate.IViewState
import kotlinx.coroutines.flow.Flow

/**
 * Created by merttoptas on 13.03.2022
 */
@Stable
data class CharactersViewState(
    val isLoading: Boolean = false,
    val pagedData: Flow<PagingData<CharacterDto>>? = null,
    val data: List<Result>? = null,
) : IViewState