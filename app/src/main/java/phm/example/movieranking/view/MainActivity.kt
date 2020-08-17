package phm.example.movieranking.view

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import phm.example.movieranking.adapter.MovieAdapter
import phm.example.movieranking.R
import phm.example.movieranking.base.BaseActivity
import phm.example.movieranking.databinding.ActivityMainBinding
import phm.example.movieranking.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutResourceId: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel by viewModel()

    private val movieAdapter: MovieAdapter by inject()

    private val key = "발급받은_영화API_키"

    override fun initStartView() {
        Log.d("MainActivity", "initStartView")
        recycler.run {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    override fun initDataBinding() {
        Log.d("MainActivity", "initDataBinding")

        viewModel.MovieResponseLiveData.observe(this, Observer {

            it.boxOfficeResult?.dailyBoxOfficeList?.let { it1 -> movieAdapter.setMovieList(it1) }

            movieAdapter.notifyDataSetChanged()
        })


    }

    override fun initAfterBinding() {
        Log.d("MainActivity", "initAfterBinding")

        search.setOnClickListener {
            viewModel.getMovieRanking(key, date.text.toString())
        }
    }

}
