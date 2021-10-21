package com.ideas.cinco.mvvm.domain

import com.ideas.cinco.mvvm.data.QuoteRepository
import com.ideas.cinco.mvvm.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository=QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>?= repository.getAllQuotes()

}