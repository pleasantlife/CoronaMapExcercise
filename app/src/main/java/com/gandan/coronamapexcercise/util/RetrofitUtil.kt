package com.gandan.coronamapexcercise.util

import android.util.Log
import com.gandan.coronamapexcercise.repository.MaskAPIInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtil {

    private val url = "https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/storesByGeo/"

    fun getRetrofit(): MaskAPIInterface {

        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

         return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
             .client(okHttpClient)
            .build().create(MaskAPIInterface::class.java)
    }
}