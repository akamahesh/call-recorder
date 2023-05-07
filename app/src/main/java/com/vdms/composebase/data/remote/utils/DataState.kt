package com.vdms.composebase.data.remote.utils

import com.vdms.composebase.data.model.APIError

/**
 * Created by merttoptas on 12.03.2022
 */

sealed class DataState<T> {
    class Success<T>(val data: T) : DataState<T>()
    class Loading<T> : DataState<T>()
    class Error<T>(val apiError: APIError?) : DataState<T>()
}