package com.ideas.cinco.mvvm.domain

import com.ideas.cinco.mvvm.data.model.QuoteModel
import com.ideas.cinco.mvvm.data.model.quoteProvider

class GetRandomQuotesUseCase {
    operator fun invoke(): QuoteModel?{
        val quotes = quoteProvider.qutes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (0..quotes.size-1).random()
            return quotes[randomNumber]
        }
        return null
    }
}
