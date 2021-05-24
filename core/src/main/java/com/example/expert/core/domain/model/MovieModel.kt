package com.example.expert.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieModel(
    var id: Int,
    var title: String,
    var releaseDate: String?,
    var overview: String?,
    var photo: String,
    var voteAverage: Double,
) : Parcelable