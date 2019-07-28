package com.mina.coroutinesdemo.ui.home

import androidx.lifecycle.ViewModelProviders
import com.mina.coroutinesdemo.R
import com.mina.coroutinesdemo.base.BaseActivity

class HomeActivity :BaseActivity(){

    override fun getLayout() = R.layout.activity_main

    override fun onCreateActivityComponent() {

        val homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java);
        homeViewModel.getData()

    }

}