package com.example.expert.core.data.source.remote.network

import com.example.expert.BuildConfig
import com.example.expert.core.data.source.remote.response.DetailResponse
import com.example.expert.core.data.source.remote.response.ListMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("top_rated?api_key=${BuildConfig.API_KEY}&language=en-US&page=1")
    suspend fun getList(): ListMoviesResponse

    @GET("{id}?api_key=4fbb574d40e5a203eb420b122b634494&language=en-US")
    suspend fun getDetails(@Path("id") id: String): DetailResponse
}