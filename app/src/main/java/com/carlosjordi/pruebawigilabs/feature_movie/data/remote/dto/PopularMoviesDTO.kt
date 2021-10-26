package com.carlosjordi.pruebawigilabs.feature_movie.data.remote.dto


import com.google.gson.annotations.SerializedName

data class PopularMoviesDTO(
    val page: Int,
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)