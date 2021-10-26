package com.carlosjordi.pruebawigilabs.feature_movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.carlosjordi.pruebawigilabs.feature_movie.presentation.ui.theme.PruebaWigiLabsTheme
import com.carlosjordi.pruebawigilabs.navigation.MovieNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaWigiLabsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    MovieNavigation(navHostController = navController)
                }
            }
        }
    }
}