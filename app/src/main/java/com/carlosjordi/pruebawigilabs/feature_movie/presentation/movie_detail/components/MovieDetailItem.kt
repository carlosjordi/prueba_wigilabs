package com.carlosjordi.pruebawigilabs.feature_movie.presentation.movie_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.carlosjordi.pruebawigilabs.R
import com.carlosjordi.pruebawigilabs.core.components.MovieDescription
import com.carlosjordi.pruebawigilabs.core.components.MoviePoster
import com.carlosjordi.pruebawigilabs.core.components.MovieTitle
import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.Movie
import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.imagePath

@Composable
fun MovieDetailItem(movie: Movie) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(state = scrollState)
    ) {
        MoviePoster(
            moviePoster = movie.imagePath(),
            height = 560.dp
        )
        Spacer(modifier = Modifier.height(8.dp))
        MovieTitle(title = movie.title)
        Spacer(modifier = Modifier.height(8.dp))
        MovieDescription(description = movie.overview)
        Spacer(modifier = Modifier.height(8.dp))
        MovieVoteSection(
            voteCount = movie.voteCount,
            voteAverage = movie.voteAverage
        )
        Spacer(modifier = Modifier.height(8.dp))
        MoviePopularitySection(
            date = movie.releaseDate,
            popularity = movie.popularity
        )
    }
}

@Composable
fun MovieVoteSection(
    voteCount: Int,
    voteAverage: Double
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = (voteAverage * 10).toString() + "%")
        Text(text = stringResource(id = R.string.movie_rated, voteCount))
    }
}

@Composable
fun MoviePopularitySection(
    date: String,
    popularity: Double
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = stringResource(id = R.string.movie_popularity, popularity.toString()))
        Text(text = date)
    }
}