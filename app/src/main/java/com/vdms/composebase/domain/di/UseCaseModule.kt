package com.vdms.composebase.domain.di

import com.vdms.composebase.domain.repository.CharacterRepository
import com.vdms.composebase.domain.usecase.characters.GetCharactersFilterUseCase
import com.vdms.composebase.domain.usecase.characters.GetCharactersUseCase
import com.vdms.composebase.domain.usecase.favorite.DeleteFavoriteUseCase
import com.vdms.composebase.domain.usecase.favorite.GetFavoritesUseCase
import com.vdms.composebase.domain.usecase.favorite.UpdateFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Created by merttoptas on 27.03.2022
 */

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @ViewModelScoped
    @Provides
    fun provideGetCharactersUseCase(
        characterRepository: CharacterRepository
    ) = GetCharactersUseCase(characterRepository)

    @ViewModelScoped
    @Provides
    fun provideUpdateFavoriteUseCase(
        characterRepository: CharacterRepository
    ) = UpdateFavoriteUseCase(characterRepository)

    @ViewModelScoped
    @Provides
    fun provideDeleteFavoriteUseCase(
        characterRepository: CharacterRepository
    ) = DeleteFavoriteUseCase(characterRepository)

    @ViewModelScoped
    @Provides
    fun provideGetFavoritesUseCase(
        characterRepository: CharacterRepository
    ) = GetFavoritesUseCase(characterRepository)

    @ViewModelScoped
    @Provides
    fun provideGetCharactersFilterUseCase(
        characterRepository: CharacterRepository
    ) = GetCharactersFilterUseCase(characterRepository)
}