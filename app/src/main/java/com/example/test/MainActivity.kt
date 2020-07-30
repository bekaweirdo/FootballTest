package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.test.viewmodel.StadiumViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var stadiumViewModel: StadiumViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stadiumViewModel = ViewModelProviders.of(this).get(stadiumViewModel::class.java)

    }
}