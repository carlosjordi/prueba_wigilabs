package com.carlosjordi.pruebawigilabs.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.carlosjordi.pruebawigilabs.core.Constants
import com.carlosjordi.pruebawigilabs.feature_movie.presentation.movie_detail.MovieDetailScreen
import com.carlosjordi.pruebawigilabs.feature_movie.presentation.popular_movies_list.MovieListScreen

@Composable
fun MovieNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.MovieList.route
    ) {
        composable(route = Screen.MovieList.route) {
            MovieListScreen(navController = navHostController)
        }
        composable(
            route = Screen.MovieDetail.route + "/{${Constants.KEY_MOVIE_ID}}",
            arguments = listOf(
                navArgument(
                    name = Constants.KEY_MOVIE_ID
                ) {
                    type = NavType.IntType
                }
            )
        ) {
            MovieDetailScreen()
        }
    }
}