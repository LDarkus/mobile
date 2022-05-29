package com.example.filmsapp.screens.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.filmsapp.REALIZATION
import com.example.filmsapp.date.room.repository.MoviesRepositoryRealization
import com.example.filmsapp.models.MovieItemModel

class FavoriteFragmentViewModel: ViewModel() {

    //Получение списка
    fun getAllMovies():LiveData<List<MovieItemModel>>{
        return REALIZATION.allMovies
    }
}