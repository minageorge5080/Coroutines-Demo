package com.mina.coroutinesdemo.base

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

open class BaseViewModel : ViewModel() {

    val viewModelJob = SupervisorJob()
    val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val handler = CoroutineExceptionHandler { _, exception ->
        Log.d("minaError", exception.localizedMessage)
    }

    override fun onCleared() {
        viewModelJob.cancel()
        super.onCleared()
    }
}