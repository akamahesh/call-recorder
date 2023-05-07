package com.vdms.composebase.domain.usecase.characters

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.vdms.composebase.data.model.dto.CharacterDto
import com.vdms.composebase.domain.base.BaseUseCase
import com.vdms.composebase.domain.base.IParams
import com.vdms.composebase.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by merttoptas on 27.03.2022
 */

class GetCharactersUseCase(
    internal val repository: CharacterRepository
) : BaseUseCase<GetCharactersUseCase.Params, PagingData<CharacterDto>> {

    data class Params(
        val pagingConfig: PagingConfig,
        val options: Map<String, String>
    ) : IParams

    override suspend fun invoke(param: Params): Flow<PagingData<CharacterDto>> {
        return Pager(
            config = param.pagingConfig,
            pagingSourceFactory = { CharacterPagingSource(repository, param.options) }
        ).flow
    }
}