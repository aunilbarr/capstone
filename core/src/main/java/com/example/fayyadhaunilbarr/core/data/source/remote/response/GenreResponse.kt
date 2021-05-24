package com.example.fayyadhaunilbarr.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @field:SerializedName("id")
    val genreId: Int,

    @field:SerializedName("name")
    val genre: String
)