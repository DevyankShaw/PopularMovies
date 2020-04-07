package com.example.devyankshaw.moviemvvm.data.api

import com.example.devyankshaw.moviemvvm.data.vo.MovieDetails
import com.example.devyankshaw.moviemvvm.data.vo.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBInterface {

    // https://api.themoviedb.org/3/movie/popular?api_key=d0a5923259cf3e63975e0a671bdcf154&page=1
    // https://api.themoviedb.org/3/movie/299534?api_key=d0a5923259cf3e63975e0a671bdcf154
    // https://api.themoviedb.org/3/

    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int): Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
}