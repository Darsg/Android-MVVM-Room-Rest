package com.example.android_mvvm_room_rest.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.android_mvvm_room_rest.dao.ItemDao
import com.example.android_mvvm_room_rest.database.ItemDatabase
import com.example.android_mvvm_room_rest.model.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemRepository(application: Application) {
    private val database: ItemDatabase = ItemDatabase.getInstance(application)
    private val itemDao: ItemDao = database.itemDao()
    private val getAllItem: LiveData<List<Item>> = itemDao.getAllItems()

    fun insert(itemList: List<Item>) {
        CoroutineScope(Dispatchers.IO).launch {
            itemList.forEach { item ->
                println("Inserting item: ${item.title}, ${item.description}")
            }
            itemDao.insert(itemList)
        }
    }


    fun getAllItems(): LiveData<List<Item>> {
        return getAllItem
    }
}
