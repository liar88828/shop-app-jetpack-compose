package com.tutor.eshop.viewmodel.eshop

import com.tutor.eshop.data.EShopApi
import com.tutor.eshop.data.model.EStores
import com.tutor.eshop.data.model.EStoresItem
import javax.inject.Inject

class EShopRepository
@Inject constructor(
	private val api: EShopApi
) {

	suspend fun getProducts(): EStores {
		return api.getProducts()
	}

	suspend fun getProductId(id: Int): EStoresItem {
		return api.getProductId(id)
	}

}
