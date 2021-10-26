package com.carlosjordi.pruebawigilabs.feature_movie.data.remote

import com.carlosjordi.pruebawigilabs.core.Constants
import com.carlosjordi.pruebawigilabs.feature_movie.data.remote.dto.PopularMoviesDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDbApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): PopularMoviesDTO
}