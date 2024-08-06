package com.tutor.eshop.viewmodel.eshop

sealed interface EShopEvent {
	data object GetProducts : EShopEvent
	class GetProduct(val id: Int) : EShopEvent
}