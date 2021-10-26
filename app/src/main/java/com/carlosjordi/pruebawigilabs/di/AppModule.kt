package com.carlosjordi.pruebawigilabs.di

import android.app.Application
import androidx.room.Room
import com.carlosjordi.pruebawigilabs.core.Constants
import com.carlosjordi.pruebawigilabs.feature_movie.data.local.MovieDao
import com.carlosjordi.pruebawigilabs.feature_movie.data.local.MoviesDatabase
import com.carlosjordi.pruebawigilabs.feature_movie.data.remote.TheMovieDbApi
import com.carlosjordi.pruebawigilabs.feature_movie.data.repository.MoviesRepositoryImpl
import com.carlosjordi.pruebawigilabs.feature_movie.domain.repository.IMoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTheMovieDbApi(): TheMovieDbApi =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TheMovieDbApi::class.java)

    @Provides
    @Singleton
    fun provideMovieDao(database: MoviesDatabase): MovieDao =
        database.movieDao

    @Provides
    @Singleton
    fun provideMovieDatabase(app: Application): MoviesDatabase =
        Room.databaseBuilder(
            app,
            MoviesDatabase::class.java,
            Constants.MOVIES_DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideMovieRepository(api: TheMovieDbApi, dao: MovieDao): IMoviesRepository =
        MoviesRepositoryImpl(api, dao)

}