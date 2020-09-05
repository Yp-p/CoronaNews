package com.tphtwe.newswide.api

import com.tphtwe.newswide.model.model1.AllCountry1
import com.tphtwe.newswide.model.model1.AllCountry1Item
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("v2/countries")
    fun getCountries(

    ):Call<AllCountry1>

}