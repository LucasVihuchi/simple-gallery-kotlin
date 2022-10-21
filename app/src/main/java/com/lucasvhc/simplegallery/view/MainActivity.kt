package com.lucasvhc.simplegallery.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucasvhc.simplegallery.databinding.ActivityMainBinding
import com.lucasvhc.simplegallery.view.adapter.GalleryAdapter
import com.lucasvhc.simplegallery.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private val adapter = GalleryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerCards.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.recyclerCards.adapter = adapter

        supportActionBar?.hide()

        observe()
    }

    override fun onResume() {
        super.onResume()

        viewModel.updateCards()
    }

    private fun observe() {
        viewModel.cards.observe(this) {
            adapter.updateGalleryCards(it)
        }
    }
}