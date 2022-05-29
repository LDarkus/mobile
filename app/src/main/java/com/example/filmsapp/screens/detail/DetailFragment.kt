package com.example.filmsapp.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmsapp.MAIN
import com.example.filmsapp.R
import com.example.filmsapp.SaveShared
import com.example.filmsapp.databinding.FragmentDetailBinding
import com.example.filmsapp.databinding.FragmentFavoriteBinding
import com.example.filmsapp.models.MovieItemModel
import com.example.filmsapp.screens.main.MainFragmentViewModel


class DetailFragment : Fragment() {

    private var mBinding : FragmentDetailBinding?= null
    private val binding get() = mBinding!!
    lateinit var currentMovie : MovieItemModel
    private var isFavorite = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mBinding= FragmentDetailBinding.inflate(layoutInflater,container,false)
        //Получение выборанной модели
        currentMovie= arguments?.getSerializable("movie") as MovieItemModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val valueBool = SaveShared.getFavorite(MAIN,currentMovie.id.toString())
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        if(isFavorite !=valueBool ) {
            binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
        }else{
            binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }

        Glide.with(MAIN).load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${currentMovie.poster_path}").centerCrop().placeholder(R.drawable.ic_launcher_foreground).into(binding.imgDetail)
        binding.tvTitle.text=currentMovie.title
        binding.tvDate.text=currentMovie.release_date
        binding.tvDescription.text=currentMovie.overview
        //Обработка нажатия на картинку
        binding.imgDetailFavorite.setOnClickListener{
            if(isFavorite == valueBool)
            {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                SaveShared.setFavorite(MAIN,currentMovie.id.toString(),true)
                viewModel.insert(currentMovie){}
                isFavorite=true
            }
            else
            {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                SaveShared.setFavorite(MAIN,currentMovie.id.toString(),false)
                viewModel.delete(currentMovie){}
                isFavorite=false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding=null
    }


}