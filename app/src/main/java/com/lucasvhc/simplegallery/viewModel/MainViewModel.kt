package com.lucasvhc.simplegallery.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasvhc.simplegallery.clients.GalleryClient
import com.lucasvhc.simplegallery.entities.CardEntity
import com.lucasvhc.simplegallery.entities.GalleryEntity
import com.lucasvhc.simplegallery.services.GalleryService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val service = GalleryClient.createService(GalleryService::class.java)

    private val _cards: MutableLiveData<List<CardEntity>> by lazy {
        MutableLiveData<List<CardEntity>>().also {
            loadCards()
        }
    }
    val cards: LiveData<List<CardEntity>> = _cards

    fun updateCards() {
        loadCards()
    }

    private fun loadCards() {
        val call: Call<GalleryEntity> = service.getCardsInfo()
        call.enqueue(object : Callback<GalleryEntity> {
            override fun onResponse(call: Call<GalleryEntity>, response: Response<GalleryEntity>) {
                Log.i("[RETROFIT SUCCESS]", "Successfully got gallery ads")
                _cards.value = response.body()?.cardsInfo
            }

            override fun onFailure(call: Call<GalleryEntity>, t: Throwable) {
                Log.e("[RETROFIT ERROR]", "Error getting gallery ads")
                _cards.value = listOf<CardEntity>(
                    CardEntity("Título A", "Subtítulo A", "Preço A", "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"),
                    CardEntity("Título B", "Subtítulo B", "Preço B", "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"),
                    CardEntity("Título C", "Subtítulo C", "Preço C", "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"),
                    CardEntity("Título D", "Subtítulo D", "Preço D", "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"),
                    CardEntity("Título E", "Subtítulo E", "Preço E", "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg")
                )
            }

        })
    }
}