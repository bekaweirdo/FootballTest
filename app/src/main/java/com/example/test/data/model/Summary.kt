package com.example.test.data.model

data class Summary(
    val actionTime: String,
    val team1Action: ArrayList<TeamAction>,
    val team2Action: ArrayList<TeamAction>
)