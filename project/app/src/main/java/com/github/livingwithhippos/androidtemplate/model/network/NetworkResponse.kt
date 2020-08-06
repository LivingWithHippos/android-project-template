package com.github.livingwithhippos.androidtemplate.model.network

sealed class NetworkResponse<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResponse<T>()
    data class SuccessEmptyBody(val code: Int) : NetworkResponse<Nothing>()
    data class Error(val exception: Exception) : NetworkResponse<Nothing>()
}