package com.robert.mvvm.data

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface PeopleService {
    @GET
    fun fetchPeople(@Url url: String?): Observable<PeopleResponse?>
}