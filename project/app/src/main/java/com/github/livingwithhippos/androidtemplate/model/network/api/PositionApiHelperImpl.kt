package com.github.livingwithhippos.androidtemplate.model.network.api

import retrofit2.Response
import javax.inject.Inject

class PositionApiHelperImpl @Inject constructor(private val positionsApi: PositionsApi) :
    PositionsApiHelper {

    override suspend fun getPositions(
        description: String,
        location: String?,
        lat: String?,
        long: String?,
        full_time: Boolean?,
        page: Int?
    ): Response<List<Position>> =
        positionsApi.getPositions(description, location, lat, long, full_time, page)
}