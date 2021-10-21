package com.example.recyclerviewfromapibonus

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("people/")
    fun getClient(): Call<Person?>?
}