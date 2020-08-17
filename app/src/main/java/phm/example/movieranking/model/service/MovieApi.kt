package phm.example.movieranking.model.service

import io.reactivex.Observable
import io.reactivex.Single
import phm.example.movieranking.model.response.Movie
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieApi {

    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    fun getMovie(
        @Query("key") key:String,
        @Query("targetDt") targetDt:String): Single<Movie>

}