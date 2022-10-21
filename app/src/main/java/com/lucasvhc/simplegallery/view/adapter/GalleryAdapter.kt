package com.lucasvhc.simplegallery.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucasvhc.simplegallery.databinding.GalleryCardBinding
import com.lucasvhc.simplegallery.entities.CardEntity
import com.lucasvhc.simplegallery.view.viewHolder.GalleryViewHolder

class GalleryAdapter: RecyclerView.Adapter<GalleryViewHolder>() {
    private var cardsList: List<CardEntity> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val item = GalleryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GalleryViewHolder(item)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(cardsList[position])
    }

    override fun getItemCount(): Int {
        return cardsList.count()
    }

    fun updateGalleryCards(list: List<CardEntity>) {
        cardsList = list
        notifyDataSetChanged()
    }
}