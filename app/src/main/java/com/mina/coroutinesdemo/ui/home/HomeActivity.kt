package com.mina.coroutinesdemo.ui.home

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mina.coroutinesdemo.R
import com.mina.coroutinesdemo.base.BaseActivity

class HomeActivity : BaseActivity() {

    override fun getLayout() = R.layout.activity_main

    override fun onCreateActivityComponent() {

        val homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java);
        homeViewModel.liveData.observe(this, Observer {
            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
        })
    }

}