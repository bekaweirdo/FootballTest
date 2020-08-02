package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.test.data.model.StadiumsResponse
import com.example.test.data.network.StadiumService
import com.example.test.repository.DataRepository
import com.example.test.ui.StadiumViewModelFactory
import com.example.test.ui.viewmodel.StadiumViewModel
import retrofit2.Call
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var stadiumViewModel: StadiumViewModel
    @Inject
    lateinit var stadiumViewModelFactory: StadiumViewModelFactory
    private lateinit var progressBar: ProgressBar
    private lateinit var stadiumResponse: StadiumsResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as TeamApplication).appComponent.inject(this)
        stadiumViewModel = ViewModelProviders.of(this,stadiumViewModelFactory)[StadiumViewModel::class.java]
        loadData()
    }
    
    private fun loadData(){
        progressBar = findViewById(R.id.progressBar)
        val apiService = StadiumService.create()
        apiService.getStadiums()
        stadiumViewModel.getStadiums()
        stadiumViewModel.listOfStadiums.observe(this, Observer {
            stadiumResponse = it
            Log.d("MainActivity", stadiumResponse.results.toString())
        })
    }
}