package com.example.filmsapp.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmsapp.REALIZATION
import com.example.filmsapp.date.retrofit.RetrofitRepository
import com.example.filmsapp.date.room.MoviesRoomDatabase
import com.example.filmsapp.date.room.repository.MoviesRepositoryRealization
import com.example.filmsapp.models.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = RetrofitRepository()

    val myMovies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()
    val context=application


    fun getMoviesRetrofit(){
        viewModelScope.launch {
            myMovies.value=repository.getMovies()
        }
    }
    fun initDatabase(){
        //Берем нашу БД
        val daoMovie = MoviesRoomDatabase.getInstance(context).getMovieDao()
        REALIZATION= MoviesRepositoryRealization(daoMovie)
    }
}