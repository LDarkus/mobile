package com.example.filmsapp.date.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.filmsapp.models.MovieItemModel

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movieItemModel: MovieItemModel)
    @Delete
    suspend fun delete(movieItemModel: MovieItemModel)
    @Query("SELECT * from movie_table")
    fun getAllMovies(): LiveData<List<MovieItemModel>>
}