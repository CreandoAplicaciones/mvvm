package com.ideas.cinco.mvvm.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ideas.cinco.mvvm.data.model.QuoteModel
import com.ideas.cinco.mvvm.data.model.quoteProvider
import com.ideas.cinco.mvvm.domain.GetQuotesUseCase
import com.ideas.cinco.mvvm.domain.GetRandomQuotesUseCase
import kotlinx.coroutines.launch

class quoteViewModel : ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()


    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuotesUseCase = GetRandomQuotesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }

        }
    }


    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuotesUseCase()
        if(quote!=null){
            quoteModel.postValue(quote!!)
        }
        isLoading.postValue(false)

        /*  val currentQuote:QuoteModel =quoteProvider.random()
          quoteModel.postValue(currentQuote)

         */
    }


}