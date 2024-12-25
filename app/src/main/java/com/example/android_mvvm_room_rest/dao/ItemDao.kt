package com.example.android_mvvm_room_rest.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android_mvvm_room_rest.model.Item

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(itemList: List<Item>)

    @Query("SELECT * FROM items")
    fun getAllItems(): LiveData<List<Item>>

    @Query("DELETE FROM items")
    fun deleteAll()
}
