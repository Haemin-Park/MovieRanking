package phm.example.movieranking.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import phm.example.movieranking.base.BaseViewModel
import phm.example.movieranking.model.DataModel
import phm.example.movieranking.model.response.Movie

class MainViewModel(private val model: DataModel) : BaseViewModel() {

    private val _MovieResponseLiveData = MutableLiveData<Movie>()
    val MovieResponseLiveData: LiveData<Movie>
        get() = _MovieResponseLiveData

    fun getMovieRanking(key:String, targetDt: String) {
        addDisposable(model.getData(key, targetDt)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.run {
                    if(boxOfficeResult?.dailyBoxOfficeList != null) {
                        _MovieResponseLiveData.postValue(this)
                        Log.d("MainViewModel", "성공: " + MovieResponseLiveData.value.toString())
                    }
                }
            }, {
                Log.d("MainViewModel", "실패 : ${it.message}")
            }))
    }
}