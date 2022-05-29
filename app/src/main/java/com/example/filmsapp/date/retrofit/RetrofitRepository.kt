package com.example.filmsapp.date.retrofit

import com.example.filmsapp.date.retrofit.api.RetrofitInstance
import com.example.filmsapp.models.MoviesModel
import retrofit2.Response
import retrofit2.Retrofit

class RetrofitRepository {
    suspend fun getMovies():Response<MoviesModel>{
        return RetrofitInstance.api.getPopularMovie()
    }
}