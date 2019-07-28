package com.mina.coroutinesdemo.ui.home

import android.util.Log
import com.mina.coroutinesdemo.base.BaseViewModel
import com.mina.coroutinesdemo.store.network.APIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//https://medium.com/androiddevelopers/easy-coroutines-in-android-viewmodelscope-25bffb605471
class HomeViewModel : BaseViewModel() {

    fun getData(){
        uiScope.launch {
            Log.d("ddddddd",Thread.currentThread().name)
            Log.d("ddddddd", launchDataLoad().toString())
        }
    }

    private suspend fun launchDataLoad() = withContext(Dispatchers.IO){
        Log.d("ddddddd",Thread.currentThread().name)
        APIService().getData().await()
    }

}