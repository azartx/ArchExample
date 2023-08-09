package com.solo4.archexample.data.model

import com.google.gson.annotations.SerializedName

data class MovieEntity(
    @SerializedName("Search") val search: List<SearchEntity>,
    @SerializedName("totalResults") val totalResults: String?,
    @SerializedName("Response") val response: String?
)
