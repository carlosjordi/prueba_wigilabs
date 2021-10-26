package com.carlosjordi.pruebawigilabs.feature_movie.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.carlosjordi.pruebawigilabs.feature_movie.domain.model.Movie

@Database(
    entities = [Movie::class],
    version = 1
)
abstract class MoviesDatabase : RoomDatabase() {

    abstract val movieDao: MovieDao
}