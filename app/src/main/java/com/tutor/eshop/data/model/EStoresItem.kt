package com.tutor.eshop.data.model

import com.tutor.retrofit_app.eshop.data.model.Rating

data class EStoresItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)