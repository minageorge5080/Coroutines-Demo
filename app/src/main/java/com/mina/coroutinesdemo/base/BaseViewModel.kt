package com.mina.coroutinesdemo.base

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

open class BaseViewModel : ViewModel() {


//    init {
//        ViewModelScope.launch {
//            // Coroutine that will be canceled when the ViewModel is cleared.
//        }
//    }

    val handler = CoroutineExceptionHandler { _, exception ->
        Log.d("minaError", exception.localizedMessage)
    }

    /**
     * This is the job for all coroutines started by this ViewModel.
     * Cancelling this job will cancel all coroutines started by this ViewModel.
     */
    val viewModelJob  = SupervisorJob()

    /**
     * This is the main scope for all coroutines launched by MainViewModel.
     * Since we pass viewModelJob, you can cancel all coroutines
     * launched by uiScope by calling viewModelJob.cancel()
     */
    val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob  + handler)

    /**
     * Cancel all coroutines when the ViewModel is cleared
     */
    override fun onCleared() {
        viewModelJob .complete()
        super.onCleared()
    }
}