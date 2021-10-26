package com.carlosjordi.pruebawigilabs.feature_movie.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie ORDER BY voteAverage DESC")
    suspend fun getMovies(): List<Movie>

    @Query("SELECT * FROM movie WHERE id = :id")
    suspend fun getMovie(id: Int): Movie?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(vararg movie: Movie)
}