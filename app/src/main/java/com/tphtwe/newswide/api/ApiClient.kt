package com.tphtwe.newswide.api

import com.tphtwe.newswide.model.model1.AllCountry1
import com.tphtwe.newswide.model.model1.AllCountry1Item
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    val BASE_Country="https://corona.lmao.ninja/"

    var apiInterface:ApiInterface
    init {
        var retrofit=Retrofit.Builder().baseUrl(BASE_Country).addConverterFactory(GsonConverterFactory.create()).build()
        apiInterface=retrofit.create(ApiInterface::class.java)
    }
    fun getAllCountries():Call<AllCountry1>{
        return apiInterface.getCountries()
    }
}