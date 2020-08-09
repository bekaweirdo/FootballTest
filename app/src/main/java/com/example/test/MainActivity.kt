package com.example.test

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.test.data.model.StadiumsResponse
import com.example.test.data.network.StadiumService
import com.example.test.repository.DataRepository
import com.example.test.ui.StadiumViewModelFactory
import com.example.test.ui.viewmodel.StadiumViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var stadiumViewModel: StadiumViewModel
    @Inject
    lateinit var stadiumViewModelFactory: StadiumViewModelFactory
    private lateinit var progressBar: ProgressBar
    private lateinit var stadiumResponse: StadiumsResponse
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as TeamApplication).appComponent.inject(this)
        stadiumViewModel = ViewModelProviders.of(this,stadiumViewModelFactory)[StadiumViewModel::class.java]
        setUpNavigation()
        loadData()
    }

    private fun loadData(){
        val apiService = StadiumService.create()
        apiService.getStadiums()
        stadiumViewModel.getStadiums()
        stadiumViewModel.listOfStadiums.observe(this, Observer {
            stadiumResponse = it
            Log.d("MainActivity", stadiumResponse.results.toString())
        })
    }

    private fun setUpNavigation(){
        navController = Navigation.findNavController(this,R.id.main_nav_host_fragment)
        NavigationUI.setupWithNavController(bottom_navigation,navController)

        bottom_navigation.setOnNavigationItemSelectedListener(bottomNavigation)
    }

    private val bottomNavigation = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.matches -> {
                if (navController.currentDestination?.id != R.id.matchesFragment) {
                    navController.navigate(R.id.action_global_matchesFragment)
                }
                true
            }
            else -> true
        }
    }
}