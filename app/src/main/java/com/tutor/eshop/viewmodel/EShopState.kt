package com.tutor.eshop.viewmodel

import com.tutor.eshop.data.model.EStores
import com.tutor.eshop.data.model.EStoresItem

data class EShopState(
	val products: EStores? = null,
	var product: EStoresItem? = null,
	val message: String = "",
	var loading: Boolean = false
//	val id: Int = 0
)