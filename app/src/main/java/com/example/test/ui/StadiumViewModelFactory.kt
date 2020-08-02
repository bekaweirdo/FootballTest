package com.example.test.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.test.repository.DataRepository
import com.example.test.ui.viewmodel.StadiumViewModel
import javax.inject.Inject

class StadiumViewModelFactory @Inject constructor(private val dataRepository: DataRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StadiumViewModel(dataRepository) as T
    }
}