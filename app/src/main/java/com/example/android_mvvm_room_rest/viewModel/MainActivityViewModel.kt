package com.example.android_mvvm_room_rest.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.android_mvvm_room_rest.model.Item
import com.example.android_mvvm_room_rest.repository.ItemRepository
import com.example.android_mvvm_room_rest.network.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private var itemRepository: ItemRepository = ItemRepository(application)
    private var getAllItems: LiveData<List<Item>> = itemRepository.getAllItems()

    fun insert(list: List<Item>) {
        itemRepository.insert(list)
    }

    fun getAllItems(): LiveData<List<Item>> {
        return getAllItems
    }

    // Network request moved to ViewModel
    fun fetchDataFromAPI() {
        val retrofit = Retrofit()
        val call = retrofit.api.getProductList()

        call.enqueue(object : Callback<List<Item>> {
            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        insert(it)
                        Log.e("ViewModel", "onResponse: ${response.body()}")
                    }
                } else {
                    Log.e("ViewModel", "Error response: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                Log.e("ViewModel", "Network request failed: ${t.message}")
            }
        })
    }
}
