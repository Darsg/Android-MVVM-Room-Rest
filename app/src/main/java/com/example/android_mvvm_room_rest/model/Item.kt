package com.example.android_mvvm_room_rest.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "items", indices = [Index(value = ["id"], unique = true)])
data class Item(
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: Int,

    @SerializedName("title")
    @ColumnInfo(name = "title")
    var title: String = "",

    @SerializedName("price")
    @ColumnInfo(name = "price")
    var price: Double = 0.0,

    @SerializedName("description")
    @ColumnInfo(name = "description")
    var description: String = "",

    @SerializedName("image")
    @ColumnInfo(name = "image")
    var image: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    var itemId: Int = 0

    override fun toString(): String {
        return "Actor(actorId=$itemId, id=$id, name=$title, image='$price', age=$description, age=$image)"
    }
}


/*
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(

    @PrimaryKey
    val id: Int,
    val title: String,
    val price: Int,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating,
)*/
