package com.vdms.composebase.features.screen.settings

import androidx.lifecycle.viewModelScope
import com.vdms.composebase.RickAndMortyApp
import com.vdms.composebase.domain.viewstate.IViewEvent
import com.vdms.composebase.domain.viewstate.settings.SettingsViewState
import com.vdms.composebase.features.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by merttoptas on 22.03.2022
 */

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val application: RickAndMortyApp
) : BaseViewModel<SettingsViewState, SettingsViewEvent>() {

    init {
        setState { currentState.copy(isDark = application.isDark.value) }
    }

   private fun onChangeTheme() {
        viewModelScope.launch {
            application.toggleTheme()
            setState { currentState.copy(isDark = application.isDark.value) }
        }
    }

    override fun onTriggerEvent(event: SettingsViewEvent) {
        viewModelScope.launch {
            when (event) {
                is SettingsViewEvent.OnChangeTheme -> onChangeTheme()
            }
        }
    }

    override fun createInitialState() = SettingsViewState()
}

sealed class SettingsViewEvent : IViewEvent {
    object OnChangeTheme : SettingsViewEvent()
}
