package com.ideas.cinco.mvvm.data

import com.ideas.cinco.mvvm.data.model.QuoteModel
import com.ideas.cinco.mvvm.data.model.quoteProvider
import com.ideas.cinco.mvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()
    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.qutes=response
        return response
    }
}