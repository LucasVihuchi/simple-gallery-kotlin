package com.lucasvhc.simplegallery.view.viewHolder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.lucasvhc.simplegallery.databinding.GalleryCardBinding
import com.lucasvhc.simplegallery.entities.CardEntity
import com.squareup.picasso.Picasso

class GalleryViewHolder(private val bind: GalleryCardBinding) : RecyclerView.ViewHolder(bind.root) {
    fun bind(card: CardEntity) {
        bind.textCardTitle.text = card.title
        bind.textCardSubtitle.text = card.subtitle
        bind.textCardPrice.text = card.price

        // bind.imageCard.setImageResource(R.drawable.img_dog1)
        Log.w("[SEILA]", card.image)
        Picasso.get().load(card.image).into(bind.imageCard)

    }
}