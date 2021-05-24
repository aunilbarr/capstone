package com.example.fayyadhaunilbarr.core.data.source.remote

import android.util.Log
import com.example.fayyadhaunilbarr.core.data.source.remote.network.ApiService
import com.example.fayyadhaunilbarr.core.data.source.remote.response.DetailResponse
import com.example.fayyadhaunilbarr.core.data.source.remote.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService){
    fun getAllMovies(): Flow<List<MovieResponse>> {
        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.movies
                Log.d("RemoteDataSource", dataArray.toString())
                if (dataArray.isNotEmpty()) emit(dataArray)
            } catch (e: Exception){
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getMovieDetail(id: Int): Flow<DetailResponse> {
        return flow {
            try {
                val response = apiService.getDetails(id.toString())
                emit(response)
            } catch (e: Exception){
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}