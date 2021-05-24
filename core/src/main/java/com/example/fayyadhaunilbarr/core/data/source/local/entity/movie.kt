package com.example.fayyadhaunilbarr.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class movie(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "releaseDate")
    var releaseDate: String?,
    @ColumnInfo(name = "overView")
    var overView: String?,
    @ColumnInfo(name = "imagePath")
    var imagePath: String,
    @ColumnInfo(name = "voteAverage")
    var voteAverage: Double,
)