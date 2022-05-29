package com.example.filmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.filmsapp.databinding.ActivityMainBinding
import com.example.filmsapp.databinding.FragmentFavoriteBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding?= null
    private val binding get() = mBinding!!
    lateinit var navController : NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MAIN = this
        navController = Navigation.findNavController(this,R.id.nav_host)
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding=null
    }
}