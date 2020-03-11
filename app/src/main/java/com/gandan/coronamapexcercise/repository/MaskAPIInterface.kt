package com.gandan.coronamapexcercise.repository

import com.gandan.coronamapexcercise.model.Result
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MaskAPIInterface {

    @GET("json")
    fun getStoresByGeo(
        @Query("lat") lat : Double,
        @Query("lng") lng : Double,
        @Query("m") meter: Int) : Single<Result>
}