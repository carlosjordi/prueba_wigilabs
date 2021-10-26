package com.carlosjordi.pruebawigilabs.feature_movie.data.repository

import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.Movie
import com.carlosjordi.pruebawigilabs.feature_movie.domain.repository.IMoviesRepository

class MoviesFakeRepositoryImpl : IMoviesRepository {

    private val movies = listOf(
        Movie(
            id = 438631,
            title = "Dune",
            overview = "Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive.\"",
            popularity = 8870.667,
            voteAverage = 8.1,
            voteCount = 2526,
            releaseDate = "2021-09-15",
            imageUrl = "/d5NXSklXo0qyIYkgV94XAgMIckC.jpg"
        ),
        Movie(
            id = 580489,
            title = "Venom: Let There Be Carnage",
            overview = "After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.",
            popularity = 6667.203,
            voteAverage = 7.0,
            voteCount = 1143,
            releaseDate = "2021-09-30",
            imageUrl = "/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg"
        ),
        Movie(
            id = 610253,
            title = "Halloween Kills",
            overview = "Minutes after Laurie Strode, her daughter Karen and granddaughter Allyson left masked monster Michael Myers caged and burning in Laurie's basement, Laurie is rushed to the hospital with life-threatening injuries, believing she finally killed her lifelong tormentor. But when Michael manages to free himself from Laurie's trap, his ritual bloodbath resumes. As Laurie fights her pain and prepares to defend herself against him, she inspires all of Haddonfield to rise up against their unstoppable monster. The Strode women join a group of other survivors of Michael's first rampage who decide to take matters into their own hands, forming a vigilante mob that sets out to hunt Michael down, once and for all.",
            popularity = 3298.711,
            voteAverage = 7.3,
            voteCount = 736,
            releaseDate = "2021-10-14",
            imageUrl = "/qmJGd5IfURq8iPQ9KF3les47vFS.jpg"
        )
    )

    private var shouldReturnEmptyList = false

    override suspend fun getPopularMovies(): List<Movie> {
        return if (shouldReturnEmptyList) emptyList()
        else movies
    }

    override suspend fun getMovie(id: Int): Movie? =
        movies.find { it.id == id }

    fun shouldReturnEmptyList() {
        shouldReturnEmptyList = true
    }
}