package com.example.test.repository

import android.util.Log
import com.example.test.data.model.Stadium
import com.example.test.data.model.StadiumsResponse
import com.example.test.data.network.StadiumService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class DataRepository @Inject constructor(val stadiumService: StadiumService){

    fun getStadiums(stadiumData: IStadiumData){
        stadiumService.getStadiums().enqueue(object: Callback<StadiumsResponse>{
            override fun onFailure(call: Call<StadiumsResponse>, t: Throwable) {
                stadiumData.onFailure()
            }

            override fun onResponse(
                call: Call<StadiumsResponse>,
                response: Response<StadiumsResponse>
            ) {
                stadiumData.onSuccess(response.body() as StadiumsResponse)
            }
        })
    }


    interface IStadiumData {
        fun onSuccess(data: StadiumsResponse)
        fun onFailure()
    }
}