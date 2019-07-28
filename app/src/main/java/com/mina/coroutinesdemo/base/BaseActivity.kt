package com.mina.coroutinesdemo.base

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())

        job = Job()
        onCreateActivityComponent()
    }

    @LayoutRes
    abstract fun getLayout(): Int

    abstract fun onCreateActivityComponent()

    val handler = CoroutineExceptionHandler { _, exception ->
        Toast.makeText(this, exception.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

}