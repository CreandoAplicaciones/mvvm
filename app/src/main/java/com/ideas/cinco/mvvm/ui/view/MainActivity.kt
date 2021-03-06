package com.ideas.cinco.mvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.ideas.cinco.mvvm.databinding.ActivityMainBinding
import com.ideas.cinco.mvvm.ui.viewModel.quoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: quoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->

            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })

        quoteViewModel.isLoading.observe(this, Observer {

            binding.progress.isVisible=it
        })


        binding.ViewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}