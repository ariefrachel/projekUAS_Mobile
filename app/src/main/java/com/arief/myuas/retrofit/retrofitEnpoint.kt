package com.arief.myuas.retrofit

import com.arief.myuas.DataModel
import com.arief.myuas.DataModelDua
import com.arief.myuas.DataModelTiga
import retrofit2.Call
import retrofit2.http.GET

interface retrofitEnpoint {
    @GET("asiatenggara.php")
    fun data(): Call<DataModel>

    @GET("asiatimur.php")
    fun datadua(): Call<DataModelDua>

    @GET("asiaselatan.php")
    fun datatiga(): Call<DataModelTiga>
}