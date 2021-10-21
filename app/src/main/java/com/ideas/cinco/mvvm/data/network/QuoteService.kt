package com.ideas.cinco.mvvm.data.network

import com.ideas.cinco.mvvm.core.RetrofitHelper
import com.ideas.cinco.mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class QuoteService {

    private val retrofit = RetrofitHelper.getretrofit()

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()

        }

    }
}