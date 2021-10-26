package com.carlosjordi.pruebawigilabs.feature_movie.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.carlosjordi.pruebawigilabs.core.Constants
import com.carlosjordi.pruebawigilabs.feature_movie.data.remote.dto.Result

@Entity
data class Movie(
    @PrimaryKey
    val id: Int,
    val title: String,
    val overview: String,
    val popularity: Double,
    val voteAverage: Double,
    val voteCount: Int,
    val releaseDate: String,
    val imageUrl: String
)

fun Movie.imagePath() = Constants.MOVIE_IMAGE_PATH + imageUrl

fun Movie.shortDescription() = overview.take(80) + "..."

fun List<Result>.toMovieList(): List<Movie> =
    map {
        it.toMovie()
    }


fun Result.toMovie(): Movie =
    Movie(
        id = id,
        title = title,
        overview = overview,
        popularity = popularity,
        voteAverage = voteAverage,
        voteCount = voteCount,
        releaseDate = releaseDate,
        imageUrl = posterPath
    )