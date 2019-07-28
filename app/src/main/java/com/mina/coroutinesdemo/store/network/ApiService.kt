package com.mina.coroutinesdemo.store.network

import com.google.gson.JsonObject
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("configs.php")
    fun getData(): Deferred<JsonObject>


    companion object {

        const val API_KEY = "8103fe7b95954091845175912182112"

        operator fun invoke(): ApiService {

            val okHttpClient = OkHttpClient.Builder()
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(EndPoints.baseUrl)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }

    }
}