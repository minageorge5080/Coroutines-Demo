package com.mina.coroutinesdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.mina.coroutinesdemo.store.network.APIService
import com.mina.coroutinesdemo.store.network.NetworkDispatcher
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var job: Job


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        job = Job()

        GlobalScope.launch(Dispatchers.IO + handler) {
            Log.d("ddddddd", getData().toString())
        }

    }

    suspend fun getData(): JsonObject {
        return NetworkDispatcher.retrofit.create(APIService::class.java).getData().await()
    }


    val handler = CoroutineExceptionHandler { _, exception ->
        Log.d("ddddddd", "$exception handled !")
    }


    override fun onDestroy() {
        job.cancel() // cancel the Job
        super.onDestroy()
    }
}
