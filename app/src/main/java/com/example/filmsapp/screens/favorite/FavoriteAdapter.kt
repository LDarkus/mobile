package com.example.filmsapp.screens.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmsapp.MAIN
import com.example.filmsapp.R
import com.example.filmsapp.models.MovieItemModel
import com.example.filmsapp.screens.main.MainAdapter
import com.example.filmsapp.screens.main.MainFragment
import kotlinx.android.synthetic.main.item_layout.view.*

class FavoriteAdapter  :RecyclerView.Adapter<FavoriteAdapter.MyViewHolder>() {
    var listMovies = emptyList<MovieItemModel>()
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)



    //Говорит, что будет закидывать информацию в item_layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return  MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.item_title.text = listMovies[position].title
        holder.itemView.item_date.text = listMovies[position].release_date

        Glide.with(MAIN)
            .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${listMovies[position]
                .poster_path}")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.itemView.item_img)

    }

    override fun getItemCount(): Int {
        return  listMovies.size
    }

    fun setList(list : List<MovieItemModel>){
        listMovies=list
        notifyDataSetChanged()
    }

    //Нужен для передачи модели с данными кликнутого фильма для детального просмотра
    override fun onViewAttachedToWindow(holder: MyViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            FavoriteFragment.clickMovie(listMovies[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MyViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}
