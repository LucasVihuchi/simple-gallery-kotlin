package com.lucasvhc.simplegallery.entities

import com.google.gson.annotations.SerializedName

class GalleryEntity {

    @SerializedName("cardsInfo")
    var cardsInfo: List<CardEntity> = listOf()
}