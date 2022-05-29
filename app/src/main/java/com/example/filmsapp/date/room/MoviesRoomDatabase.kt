package com.example.filmsapp.date.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.filmsapp.date.room.dao.MoviesDao
import com.example.filmsapp.models.MovieItemModel

@Database(entities = [MovieItemModel::class],version = 1)
abstract class MoviesRoomDatabase: RoomDatabase() {

    abstract fun getMovieDao():MoviesDao

    companion object{
        private var database : MoviesRoomDatabase?=null
        //Если нет бд, то создаем иначе ничего не делаем
        fun getInstance(context:Context): MoviesRoomDatabase{
            return if(database==null){
                database= Room.databaseBuilder(context,MoviesRoomDatabase::class.java,"db").build()
                database as MoviesRoomDatabase
            }else
            {
                database as MoviesRoomDatabase
            }
        }

    }
}