package com.robert.mvvm.data

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object PeopleFactory {
    private const val BASE_URL = "https://api.randomuser.me/"
    const val RANDOM_USER_URL = "https://api.randomuser.me/?results=10&nat=en"
    const val PROJECT_URL = "https://github.com/erikjhordan-rey/People-MVVM"
    fun create(): PeopleService {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(PeopleService::class.java)
    }
}