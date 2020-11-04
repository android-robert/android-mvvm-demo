package com.robert.mvvm.data.api

import com.robert.mvvm.data.PeopleResponse
import com.robert.mvvm.data.response.User
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface KeepApiService {
    @GET
    fun fetchPeople(@Url url: String?): Observable<PeopleResponse?>

    @GET("User?ver=4")
    fun login(@Query("keep_id") keepId: String?, @Query("user_facebook_id") userFacebookId: String?, @Query("user_twitter_id") userTwitterId: String?, @Query("user_line_id") userLineId: String?): Observable<User>
}