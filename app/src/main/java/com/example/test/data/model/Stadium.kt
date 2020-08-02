package com.example.test.data.model

import com.google.gson.annotations.SerializedName

data class Stadium(
    @SerializedName("team1")
    val team1: Team,
    @SerializedName("team2")
    val team2: Team,
    @SerializedName("matchTime")
    val matchTime: Double,
    @SerializedName("matchDate")
    //SimpleDataFormatter
    val matchDate: Long,
    @SerializedName("stadiumAdress")
    val stadiumAddress: String,
    @SerializedName("matchSummary")
    val matchSummary: MatchSummary
)