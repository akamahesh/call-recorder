package com.vdms.composebase.domain.viewstate.favorites

import androidx.compose.runtime.Stable
import com.vdms.composebase.data.model.FavoriteEntity
import com.vdms.composebase.domain.viewstate.IViewState

/**
 * Created by merttoptas on 30.03.2022
 */

@Stable
data class FavoritesViewState(
    val favoritesList: List<FavoriteEntity> = emptyList(),
    val favoriteId: Int? = null,
    val isDisplay: Boolean = false,
    val isAllDeleteFavorites: Boolean = false,
    val isLoading: Boolean = false,
) : IViewState