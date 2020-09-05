package com.tphtwe.newswide.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tphtwe.newswide.api.ApiClient
import com.tphtwe.newswide.model.model1.AllCountry1
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoronaViewModel : ViewModel() {

   private var result:MutableLiveData<AllCountry1> = MutableLiveData()

    fun getResult() : LiveData<AllCountry1> = result

    fun loadResult(){
        var apiClient=ApiClient()
        var call=apiClient.getAllCountries()
        call.enqueue(object :Callback<AllCountry1>{
            override fun onFailure(call: Call<AllCountry1>, t: Throwable) {

            }

            override fun onResponse(call: Call<AllCountry1>, response: Response<AllCountry1>) {
                result.value=response.body()
            }

        })
    }
}