package com.mina.coroutinesdemo.base

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

open class BaseViewModel : ViewModel() {

    val handler = CoroutineExceptionHandler { _, exception ->
        Log.d("minaError", exception.localizedMessage)
    }

    val job = SupervisorJob()
    val uiScope = CoroutineScope(Dispatchers.Main + job + handler)

    override fun onCleared() {
        job.complete()
        super.onCleared()
    }
}