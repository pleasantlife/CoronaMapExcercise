package com.gandan.coronamapexcercise.model

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("count")
    val count : Int,
    @SerializedName("stores")
    val stores : ArrayList<Store>
) {
}