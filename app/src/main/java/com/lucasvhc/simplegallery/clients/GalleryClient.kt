package com.lucasvhc.simplegallery.clients

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GalleryClient {

    companion object {
        private const val BASE_URL = "https://db2f-2804-82e8-2-219-240e-10af-c69b-8370.sa.ngrok.io/"
        private lateinit var INSTANCE: Retrofit

        fun getInstance(): Retrofit {
            if (!::INSTANCE.isInitialized) {
                val http = OkHttpClient.Builder()
                INSTANCE = Retrofit.Builder().baseUrl(BASE_URL).client(http.build()).addConverterFactory(
                    GsonConverterFactory.create()).build()
            }
            return INSTANCE
        }

        fun <S> createService(serviceInterface: Class<S>): S {
            return getInstance().create(serviceInterface)
        }
    }
}