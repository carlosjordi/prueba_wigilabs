package com.carlosjordi.pruebawigilabs.feature_movie.presentation.movie_detail.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carlosjordi.pruebawigilabs.R
import com.carlosjordi.pruebawigilabs.core.components.MovieDescription
import com.carlosjordi.pruebawigilabs.core.components.MoviePoster
import com.carlosjordi.pruebawigilabs.core.components.MovieTitle
import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.Movie
import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.imagePath
import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.votePercentage

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
        MovieDescription(
            description = movie.overview,
            isShortDescription = false
        )
        Spacer(modifier = Modifier.height(8.dp))
        MovieDetailSection(
            voteCount = movie.voteCount,
            votePercentage = movie.votePercentage(),
            popularity = movie.popularity,
            date = movie.releaseDate
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
fun MovieDetailSection(
    voteCount: Int,
    votePercentage: Float,
    popularity: Double,
    date: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(112.dp)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularVoteAverage(percentage = votePercentage)
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End
        ) {
            VotesAmount(voteCount = voteCount)
            Popularity(popularity = popularity)
            ReleaseDate(date = date)
        }
    }
}

@Composable
fun CircularVoteAverage(
    percentage: Float,
    number: Int = 100,
    fontSize: TextUnit = 24.sp,
    radius: Dp = 48.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 8.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    val currentPercentage = remember { Animatable(0f) }

    LaunchedEffect(percentage) {
        currentPercentage.animateTo(
            targetValue = percentage,
            animationSpec = tween(
                durationMillis = animDuration,
                delayMillis = animDelay
            )
        )
    }

    Box(
        modifier = Modifier.size(radius * 2f),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * currentPercentage.value,
                useCenter = false,
                style = Stroke(
                    width = strokeWidth.toPx(),
                    cap = StrokeCap.Round
                )
            )
        }
        Text(
            text = (currentPercentage.value * number).toInt().toString() + "%",
            color = Color.Black,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun VotesAmount(voteCount: Int) {
    Text(
        text = stringResource(id = R.string.movie_rated, voteCount),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
}

@Composable
fun Popularity(popularity: Double) {
    Text(
        text = stringResource(id = R.string.movie_popularity, popularity.toString()),
        fontSize = 16.sp
    )
}

@Composable
fun ReleaseDate(date: String) {
    Text(
        text = stringResource(id = R.string.movie_released_date, date),
        fontSize = 15.sp,
        fontStyle = FontStyle.Italic
    )
}