package com.vdms.composebase.features.screen.login

import androidx.lifecycle.viewModelScope
import com.vdms.composebase.domain.viewstate.IViewEvent
import com.vdms.composebase.domain.viewstate.settings.SettingsViewState
import com.vdms.composebase.features.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel<SettingsViewState, LoginViewEvent>() {

    init {

    }

   private fun onChangeTheme() {
        viewModelScope.launch {
        }
    }

    override fun onTriggerEvent(event: LoginViewEvent) {
        viewModelScope.launch {
            //when (event) { }
        }
    }

    override fun createInitialState() = SettingsViewState()
}

sealed class LoginViewEvent : IViewEvent {
    object OnLoginButton : LoginViewEvent()
}
