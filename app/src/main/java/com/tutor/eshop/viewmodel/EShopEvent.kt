package com.tutor.eshop.viewmodel

sealed interface EShopEvent {
	data object GetProducts : EShopEvent
	class GetProduct(val id: Int) : EShopEvent
}