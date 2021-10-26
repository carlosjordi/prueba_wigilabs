package com.carlosjordi.pruebawigilabs.feature_movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.carlosjordi.pruebawigilabs.feature_movie.presentation.popular_movies_list.MovieListScreen
import com.carlosjordi.pruebawigilabs.feature_movie.presentation.ui.theme.PruebaWigiLabsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaWigiLabsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MovieListScreen()
                }
            }
        }
    }
}