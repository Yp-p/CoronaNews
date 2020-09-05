package com.tphtwe.newswide.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tphtwe.newswide.api.ApiClient
import com.tphtwe.newswide.model.AllCountry
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoronaViewModel : ViewModel() {

   private var result:MutableLiveData<AllCountry> = MutableLiveData()

    fun getResult() : LiveData<AllCountry> = result

    fun loadResult(){
        var apiClient=ApiClient()
        var call=apiClient.getAllCountries()
        call.enqueue(object :Callback<AllCountry>{
            override fun onFailure(call: Call<AllCountry>, t: Throwable) {

            }

            override fun onResponse(call: Call<AllCountry>, response: Response<AllCountry>) {
                result.value=response.body()
            }

        })
    }
}