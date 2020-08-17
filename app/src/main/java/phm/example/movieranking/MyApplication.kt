package phm.example.movieranking

import android.app.Application
import org.koin.android.ext.android.startKoin
import phm.example.movieranking.di.myDiModule

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, myDiModule)
    }
}