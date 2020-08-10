package com.github.livingwithhippos.androidtemplate.model.network.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PositionsApi {
    /**
     * Get user downloads list
     * You can not use both offset and page at the same time, page is prioritized in case it happens.
     * @param description A search term, such as "ruby" or "java". This parameter is aliased to search.
     * @param location A city name, zip code, or other location search term.
     * @param lat A specific latitude. If used, you must also send long and must not send location.
     * @param long A specific longitude. If used, you must also send lat and must not send location.
     * @param full_time If you want to limit results to full time positions set this parameter to 'true'.
     * @param page You can paginate results by adding a page parameter to your queries. Pagination starts by default at 0.
     * @return a Response<List<Position>> a list of position items
     */
    @GET("positions.json")
    suspend fun getPositions(
        @Query("description") description: String,
        @Query("location") location: String?,
        @Query("lat") lat: String?,
        @Query("long") long: String?,
        @Query("full_time") full_time: Boolean?,
        @Query("page") page: Int?
    ): Response<List<Position>>
}

@JsonClass(generateAdapter = true)
data class Position(
    @Json(name = "id")
    val id: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "company")
    val company: String,
    @Json(name = "company_url")
    val companyUrl: String?,
    @Json(name = "location")
    val location: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "how_to_apply")
    val howToApply: String,
    @Json(name = "company_logo")
    val companyLogo: String?
)