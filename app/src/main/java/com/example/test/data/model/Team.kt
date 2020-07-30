package com.example.test.data.model

import com.google.gson.annotations.SerializedName

data class Team(
    val teamName: String,
    val teamImage: String,
    val score: Int,
    val ballPosition: Int
)