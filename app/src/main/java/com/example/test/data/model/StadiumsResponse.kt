package com.example.test.data.model

import com.google.gson.annotations.SerializedName

data class StadiumsResponse(
    @SerializedName("match")
    val results: Stadium,
    val resultCode: Int
)