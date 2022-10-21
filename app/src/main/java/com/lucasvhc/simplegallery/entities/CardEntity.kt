package com.lucasvhc.simplegallery.entities

import com.google.gson.annotations.SerializedName

class CardEntity() {
    constructor(title: String, subtitle: String, price: String, image: String) : this() {
        this.title = title
        this.subtitle = subtitle
        this.image = image
        this.price = price
    }

    @SerializedName("title")
    var title: String = ""

    @SerializedName("subtitle")
    var subtitle: String = ""

    @SerializedName("price")
    var price: String = ""

    @SerializedName("image")
    var image: String = ""
}