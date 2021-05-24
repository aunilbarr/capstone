package com.example.fayyadhaunilbarr.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DetailResponse(

    @field:SerializedName("genres")
    var genres : List<GenreResponse>,
)