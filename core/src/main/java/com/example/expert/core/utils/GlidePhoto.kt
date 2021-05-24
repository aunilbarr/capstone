package com.example.expert.core.utils

object GlidePhoto {
    fun createGlideImagePath(path: String): String {
        val url = "https://image.tmdb.org/t/p/w300"
        return url + path
    }
}