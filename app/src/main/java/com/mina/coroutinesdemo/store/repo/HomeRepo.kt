package com.mina.coroutinesdemo.store.repo

import com.mina.coroutinesdemo.base.BaseRepo
import com.mina.coroutinesdemo.store.network.ApiService

class HomeRepo : BaseRepo() {

    suspend fun getData() =  ApiService().getData().await()

}