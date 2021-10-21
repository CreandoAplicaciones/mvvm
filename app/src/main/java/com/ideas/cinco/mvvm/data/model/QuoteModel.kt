package com.ideas.cinco.mvvm.data.model

import com.google.gson.annotations.SerializedName

//serializedName es para coger datos de una base de dato exterior por si tuviera un nombre diferente

data class QuoteModel  (@SerializedName("quote")val quote:String, @SerializedName("Author")val author:String)