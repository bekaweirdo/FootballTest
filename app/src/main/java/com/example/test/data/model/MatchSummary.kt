package com.example.test.data.model

import com.google.gson.annotations.SerializedName

data class MatchSummary(
    @SerializedName("summaries")
    val summaries: ArrayList<Summary>
)