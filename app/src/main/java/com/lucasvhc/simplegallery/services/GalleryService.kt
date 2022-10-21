package com.lucasvhc.simplegallery.services

import com.lucasvhc.simplegallery.entities.GalleryEntity
import retrofit2.Call
import retrofit2.http.GET

interface GalleryService {
    @GET(".")
    fun getCardsInfo(): Call<GalleryEntity>
}