package com.merttoptas.composebase.domain.viewstate.settings

import androidx.compose.runtime.Stable
import com.merttoptas.composebase.domain.viewstate.IViewState

/**
 * Created by merttoptas on 22.03.2022
 */

@Stable
data class SettingsViewState(
    val isDark: Boolean = false,
) : IViewState