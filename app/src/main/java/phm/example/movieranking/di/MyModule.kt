package phm.example.movieranking.di

import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import phm.example.movieranking.adapter.MovieAdapter
import phm.example.movieranking.model.DataModel
import phm.example.movieranking.model.DataModelImpl
import phm.example.movieranking.model.service.MovieApi
import phm.example.movieranking.viewmodel.MainViewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

var BASE_URL = "https://www.kobis.or.kr"

var retrofitPart = module{
    single<MovieApi>{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }
}

var adapterPart = module {
    factory {
        MovieAdapter()
    }
}

var modelPart = module {
    factory<DataModel> {
        DataModelImpl(get())
    }
}

var viewModelPart = module {
    viewModel {
        MainViewModel(get())
    }
}

var myDiModule = listOf(retrofitPart, adapterPart, modelPart, viewModelPart)