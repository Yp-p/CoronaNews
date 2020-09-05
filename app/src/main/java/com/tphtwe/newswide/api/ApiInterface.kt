package com.tphtwe.newswide.api

import com.tphtwe.newswide.model.AllCountry
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("v2/countries")
    fun getCountries(

    ):Call<AllCountry>

}