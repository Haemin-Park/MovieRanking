package phm.example.movieranking.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_item.view.*
import phm.example.movieranking.R
import phm.example.movieranking.model.response.DailyBoxOfficeList

class MovieAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class Holder(parent:ViewGroup):RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
    ) {
        fun onBind(item: DailyBoxOfficeList){
            itemView.run {
                movienm.text = item.movieNm
            }
        }
    }

    private var movieList = ArrayList<DailyBoxOfficeList>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(parent)

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        ( holder as Holder ).onBind(movieList[position])
    }

    fun setMovieList(movieList: ArrayList<DailyBoxOfficeList>){
        this.movieList = movieList
        Log.d("MovieAdapter",movieList.toString())
    }

}