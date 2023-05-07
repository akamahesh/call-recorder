package com.vdms.composebase.domain.viewstate.splash

import androidx.compose.runtime.Stable
import com.vdms.composebase.domain.viewstate.IViewState

/**
 * Created by merttoptas on 12.03.2022
 */

@Stable
data class SplashViewState(
    val isLoading: Boolean = false
) : IViewState