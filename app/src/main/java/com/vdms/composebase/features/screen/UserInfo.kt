package com.vdms.composebase.features.screen

import androidx.compose.Model

@Model
class UserInfo(
    var userLoggedIn: Boolean = false,
    var userName: String = ""
)