package com.example.android_mvvm_room_rest.database

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.android_mvvm_room_rest.dao.ItemDao
import com.example.android_mvvm_room_rest.model.Item
import kotlin.jvm.Volatile

@Database(entities = [Item::class], version = 2, exportSchema = false)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var INSTANCE: ItemDatabase? = null

        fun getInstance(context: Context): ItemDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDatabase::class.java,
                    DATABASE_NAME
                )
                    .addCallback(callback)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

        fun deleteAllRecord(){
            val itemDao: ItemDao? = INSTANCE?.itemDao()
            itemDao?.deleteAll()
        }

        private val callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateAsyncTask(INSTANCE).execute()
            }
        }

        private const val DATABASE_NAME: String = "items"
    }

    private class PopulateAsyncTask(itemDatabase: ItemDatabase?) : AsyncTask<Void, Void, Void>() {
        private val itemDao: ItemDao? = itemDatabase?.itemDao()

        @Deprecated("Deprecated in Java")
        override fun doInBackground(vararg voids: Void): Void? {
            itemDao?.deleteAll()
            return null
        }
    }
}
