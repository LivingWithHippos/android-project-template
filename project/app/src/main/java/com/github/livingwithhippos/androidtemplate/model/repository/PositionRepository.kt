package com.github.livingwithhippos.androidtemplate.model.repository

import com.github.livingwithhippos.androidtemplate.model.network.api.Position
import com.github.livingwithhippos.androidtemplate.model.network.api.PositionsApiHelper
import javax.inject.Inject

class PositionRepository @Inject constructor(private val positionsApiHelper: PositionsApiHelper) :
    BaseRepository() {

    suspend fun getPositions(
        description: String,
        location: String?,
        lat: String?,
        long: String?,
        full_time: Boolean? = true,
        page: Int? = 0
    ): List<Position>? {

        var mLocation: String? = null
        var mLat: String? = null
        var mLong: String? = null

        if (location != null) {
            mLocation = location
        } else {
            mLat = lat
            mLong = long
        }

        val positionResponse = safeApiCall(
            call = {
                positionsApiHelper.getPositions(
                    description, mLocation, mLat, mLong,
                    full_time, page
                )
            },
            errorMessage = "Error Fetching User Info"
        )

        return positionResponse;

    }

}