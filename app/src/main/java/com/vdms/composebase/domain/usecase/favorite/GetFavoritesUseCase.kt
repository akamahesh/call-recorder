package com.vdms.composebase.domain.usecase.favorite

import com.vdms.composebase.data.model.dto.CharacterDto
import com.vdms.composebase.data.model.dto.extension.toFavoriteDtoList
import com.vdms.composebase.domain.base.BaseUseCase
import com.vdms.composebase.domain.base.IParams
import com.vdms.composebase.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.flow

/**
 * Created by merttoptas on 30.03.2022
 */

class GetFavoritesUseCase(
    internal val repository: CharacterRepository
) : BaseUseCase<IParams, List<CharacterDto>> {

    override suspend fun invoke(param: IParams) = flow {
        val favorites = repository.getFavoriteList()
        emit(favorites.toFavoriteDtoList())
    }
}