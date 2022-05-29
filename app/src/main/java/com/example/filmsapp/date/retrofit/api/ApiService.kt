package com.example.filmsapp.date.retrofit.api

import com.example.filmsapp.models.MoviesModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("3/movie/popular?api_key=5efcc417be40ba3459a40f34fad9f1c1&language=en-US&page=1")
    suspend fun getPopularMovie():Response<MoviesModel>
}