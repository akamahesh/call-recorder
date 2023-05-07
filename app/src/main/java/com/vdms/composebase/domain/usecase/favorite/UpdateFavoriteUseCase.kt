package com.vdms.composebase.domain.usecase.favorite

import com.vdms.composebase.data.model.dto.CharacterDto
import com.vdms.composebase.data.model.dto.extension.toFavoriteEntity
import com.vdms.composebase.domain.base.BaseUseCase
import com.vdms.composebase.domain.base.IParams
import com.vdms.composebase.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.flow

/**
 * Created by merttoptas on 27.03.2022
 */

class UpdateFavoriteUseCase(
    internal val repository: CharacterRepository
) : BaseUseCase<UpdateFavoriteUseCase.Params, Unit> {

    data class Params(
        val character: CharacterDto
    ) : IParams

    override suspend fun invoke(param: Params) = flow<Unit> {
        val dto = param.character
        val character = repository.getFavorite(dto.id ?: 0)
        if (character == null) {
            repository.saveFavorite(dto.toFavoriteEntity())
        } else {
            repository.deleteFavoriteById(dto.id ?: 0)
        }
        emit(Unit)
    }
}