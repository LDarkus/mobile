package com.example.filmsapp.screens.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.filmsapp.MAIN
import com.example.filmsapp.R
import com.example.filmsapp.databinding.FragmentFavoriteBinding
import com.example.filmsapp.databinding.FragmentMainBinding
import com.example.filmsapp.models.MovieItemModel
import com.example.filmsapp.screens.main.MainAdapter
import com.example.filmsapp.screens.main.MainFragmentViewModel


class FavoriteFragment : Fragment() {

    private var mBinding : FragmentFavoriteBinding?= null
    private val binding get() = mBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { FavoriteAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFavoriteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(FavoriteFragmentViewModel::class.java)
        recyclerView = binding.rvFavorite
        recyclerView.adapter = adapter
        viewModel.getAllMovies().observe(this.viewLifecycleOwner,{list->
            adapter.setList(list.asReversed())
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding=null
    }

    companion object{
        //Переход в фрагмент детализации с передачей данных
        fun clickMovie(model: MovieItemModel){
            val bundle = Bundle()
            bundle.putSerializable("movie",model)
            MAIN.navController.navigate(R.id.action_favoriteFragment_to_detailFragment,bundle)
        }
    }
}