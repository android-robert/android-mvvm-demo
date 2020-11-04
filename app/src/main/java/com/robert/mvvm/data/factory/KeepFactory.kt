package com.robert.mvvm.data.factory

import com.robert.mvvm.constant.AppConst
import com.robert.mvvm.data.PeopleService
import com.robert.mvvm.data.api.KeepApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor

object KeepFactory {
    private const val CONNECT_TIMEOUT_MINUTES: Long = 5 // 5m
    private const val READ_TIMEOUT_MINUTES: Long = 5 // 5m
    private var keepApiService: KeepApiService? = null

    fun create(): KeepApiService {
        if (keepApiService == null) {
            val httpClient = OkHttpClient.Builder()
            httpClient.connectTimeout(CONNECT_TIMEOUT_MINUTES, TimeUnit.MINUTES)
            httpClient.readTimeout(READ_TIMEOUT_MINUTES, TimeUnit.MINUTES)
            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                        .header("Accept", "application/json")
                        .method(original.method(), original.body())
                        .build()

                chain.proceed(request)
            }
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BASIC
            httpClient.addInterceptor(logging)
            val client = httpClient.build()
            val retrofit = Retrofit.Builder()
                    .baseUrl(AppConst.KEEP_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build()

            keepApiService = retrofit.create(KeepApiService::class.java)
        }

        return keepApiService!!
    }
}