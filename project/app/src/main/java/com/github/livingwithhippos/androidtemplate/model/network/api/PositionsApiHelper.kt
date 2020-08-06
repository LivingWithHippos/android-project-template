package com.github.livingwithhippos.androidtemplate.model.network.api

import retrofit2.Response

interface PositionsApiHelper {

    suspend fun getPositions(
        description: String,
        location: String?,
        lat: String?,
        long: String?,
        full_time: Boolean? = true,
        page: Int? = 0
    ): Response<List<Position>>
}