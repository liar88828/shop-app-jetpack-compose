package com.tutor.eshop.data

import com.tutor.eshop.data.model.EStores
import com.tutor.eshop.data.model.EStoresItem
import com.tutor.eshop.utils.ConstEShop
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EShopApi {
	@GET(ConstEShop.PRODUCTS)
	suspend fun getProducts(): EStores

	@GET(ConstEShop.PRODUCTS + "/{id}")
	suspend fun getProductId(@Path("id") id: Int): EStoresItem
}
