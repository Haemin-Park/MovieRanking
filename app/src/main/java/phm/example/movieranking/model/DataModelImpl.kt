package phm.example.movieranking.model

import io.reactivex.Observable
import io.reactivex.Single
import phm.example.movieranking.model.response.Movie
import phm.example.movieranking.model.service.MovieApi

class DataModelImpl(private val service:MovieApi): DataModel{

    override fun getData(key:String, targetDt: String): Single<Movie> {
        return service.getMovie(key = key, targetDt = targetDt)
    }
}