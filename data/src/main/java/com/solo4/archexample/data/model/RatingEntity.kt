package com.solo4.archexample.data.model

import com.google.gson.annotations.SerializedName

data class RatingEntity(
    @SerializedName("Source") val source: String?,
    @SerializedName("Value") val value: String?
)
