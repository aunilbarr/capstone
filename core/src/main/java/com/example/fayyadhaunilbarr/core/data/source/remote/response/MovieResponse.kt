package com.example.fayyadhaunilbarr.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("release_date")
    val releaseDate: String?,

    @field:SerializedName("overview")
    val overView: String?,

    @field:SerializedName("poster_path")
    val imagePath: String,

    @field:SerializedName("vote_average")
    val voteAverage: Double,
)