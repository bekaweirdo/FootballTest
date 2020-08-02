package com.example.test.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.data.model.StadiumsResponse
import com.example.test.repository.DataRepository

class StadiumViewModel (val dataRepository: DataRepository): ViewModel(){
    val listOfStadiums = MutableLiveData<StadiumsResponse>()

    fun getStadiums(){
        dataRepository.getStadiums(object : DataRepository.IStadiumData{
            override fun onSuccess(data: StadiumsResponse) {
                listOfStadiums.value = data
            }

            override fun onFailure() {
                //REQUEST FAILED
                Log.d("DataMissing","Something went wrong")
            }
        })
    }
}