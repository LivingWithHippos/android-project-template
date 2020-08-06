package com.github.livingwithhippos.androidtemplate.model.network

import com.github.livingwithhippos.androidtemplate.BuildConfig
import com.github.livingwithhippos.androidtemplate.model.network.api.PositionApiHelperImpl
import com.github.livingwithhippos.androidtemplate.model.network.api.PositionsApi
import com.github.livingwithhippos.androidtemplate.model.network.api.PositionsApiHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object ApiFactory {

    private const val BASE_URL = "https://jobs.github.com/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        // note: alternatively use a different build flavor
        // https://proandroiddev.com/think-before-using-buildconfig-debug-f2e279da7bad
        if (BuildConfig.DEBUG) {
            val logInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            return OkHttpClient().newBuilder()
                .addInterceptor(logInterceptor)
                .build()

        } else {

            return OkHttpClient()
                .newBuilder()
                .build()
        }

    }

    @Provides
    @Singleton
    fun apiRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    // authentication api injection
    @Provides
    @Singleton
    fun providePositionsApi(retrofit: Retrofit): PositionsApi {
        return retrofit.create(PositionsApi::class.java)
    }

    @Provides
    @Singleton
    fun providePositionsApiHelper(apiHelper: PositionApiHelperImpl): PositionsApiHelper =
        apiHelper
}