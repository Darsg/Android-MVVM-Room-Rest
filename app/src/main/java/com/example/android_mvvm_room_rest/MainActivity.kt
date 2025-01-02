package com.example.android_mvvm_room_rest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_mvvm_room_rest.adapter.ItemAdapter
import com.example.android_mvvm_room_rest.model.Item
import com.example.android_mvvm_room_rest.viewModel.MainActivityViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var actorViewModal: MainActivityViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var actorList: MutableList<Item>
    private lateinit var actorAdapter: ItemAdapter
    private lateinit var faButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing Views
        recyclerView = findViewById(R.id.recyclerview)
        faButton = findViewById(R.id.faButton)

        // Setup RecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()

        // Assign ViewModel
        actorViewModal = ViewModelProvider(this)[MainActivityViewModel::class.java]

        // Call the network request from ViewModel
        actorViewModal.fetchDataFromAPI()

        // Set Adapter in RecyclerView
        actorList = mutableListOf()
        actorAdapter = ItemAdapter(this, actorList)

        // Observing data ... Chill, we will get it from viewModel
        actorViewModal.getAllItems().observe(this) { actors ->
            recyclerView.adapter = actorAdapter
            actorAdapter.getAllItems(actors)
            Log.e("main", "list in mainActivity $actors")
        }

        faButton.setOnClickListener {
            // TODO Do something here for delete all record else insert record
        }
    }
}
