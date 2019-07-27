package com.mina.coroutinesdemo.store.network

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface APIService {

    @GET("configs.php")
    fun getData(): Deferred<JsonObject>

}