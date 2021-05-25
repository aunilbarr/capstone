package com.example.expert.core.utils

import android.util.Log
import com.example.expert.core.data.source.remote.response.DetailResponse
import com.example.expert.core.data.source.remote.response.MovieResponse
import com.example.expert.core.domain.model.DetailModel
import com.example.expert.core.domain.model.MovieModel

object DataMapper {
    fun mapResponsesToDomain(input: List<MovieResponse>): List<MovieModel> {
        val movieList = ArrayList<MovieModel>()
        input.map {
            val movie = MovieModel(
                it.id,
                it.title,
                it.releaseDate,
                it.overView,
                it.imagePath,
                it.voteAverage
            )
            movieList.add(movie)
        }
        Log.d("DataMapper", movieList.toString())
        return movieList
    }

    fun mapResponseToDomain(input: DetailResponse): DetailModel {
        val genres = ArrayList<String>()
        for (i in input.genres) {
            genres.add(i.genre)
        }
        return DetailModel(
            genres
        )
    }

    fun mapEntitiesToDomain(input: List<com.example.expert.core.data.source.local.entity.movie>): List<MovieModel> {
        val movieList = ArrayList<MovieModel>()
        input.map {
            val movie = MovieModel(
                it.id,
                it.title,
                it.releaseDate,
                it.overView,
                it.imagePath,
                it.voteAverage
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapDomainToEntity(input: MovieModel): com.example.expert.core.data.source.local.entity.movie {
        return com.example.expert.core.data.source.local.entity.movie(
            input.id,
            input.title,
            input.releaseDate,
            input.overview,
            input.photo,
            input.voteAverage
        )
    }
}