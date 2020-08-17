package phm.example.movieranking.model

import io.reactivex.Observable
import io.reactivex.Single
import phm.example.movieranking.model.response.Movie

interface DataModel {
    fun getData(key:String, targetDt:String): Single<Movie>
}