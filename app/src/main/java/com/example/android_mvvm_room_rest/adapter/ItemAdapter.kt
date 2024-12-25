package com.example.android_mvvm_room_rest.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_mvvm_room_rest.R
import com.example.android_mvvm_room_rest.model.Item

class ItemAdapter(private val context: Context, private var actorList: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ActorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_roe, parent, false)
        return ActorViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        val item = actorList[position]
        holder.tvTitle.text = item.title
        holder.tvDescription.text = item.description

        Glide.with(context)
            .load(item.image)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return actorList.size
    }

    fun getAllItems(actorList: List<Item>) {
        this.actorList = actorList
        notifyDataSetChanged() // Notify adapter that data has changed
    }

    inner class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val imageView: ImageView = itemView.findViewById(R.id.imgView)
    }
}

