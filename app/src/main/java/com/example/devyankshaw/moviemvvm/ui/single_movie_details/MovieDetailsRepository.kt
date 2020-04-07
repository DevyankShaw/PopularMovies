package com.example.devyankshaw.moviemvvm.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.example.devyankshaw.moviemvvm.data.api.TheMovieDBInterface
import com.example.devyankshaw.moviemvvm.data.repository.MovieDetailsNetworkDataSource
import com.example.devyankshaw.moviemvvm.data.repository.NetworkState
import com.example.devyankshaw.moviemvvm.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }



}