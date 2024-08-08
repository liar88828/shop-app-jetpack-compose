package com.tutor.eshop.screen.app.cart.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tutor.eshop.data.model.exampleItem
import com.tutor.eshop.screen.app.cart.CartProductItem
import com.tutor.eshop.screen.app.cart.CartScreen
import com.tutor.eshop.screen.app.cart.CheckOutScreen
import com.tutor.eshop.screen.app.cart.ListRowProductScreen
import com.tutor.eshop.screen.app.cart.MarketProfileScreen
import com.tutor.eshop.screen.app.cart.PersonCommentScreen
import com.tutor.eshop.screen.app.cart.PersonDelivery
import com.tutor.eshop.screen.app.cart.PurchasedScreen
import com.tutor.eshop.screen.app.cart.VerticalProductItem

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CheckOutScreenPrev() {
	CheckOutScreen()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PersonDeliveryPrev() {
	PersonDelivery()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PersonCommentPrev() {
	PersonCommentScreen()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ListRowProductPrev() {
	ListRowProductScreen()
}

@Preview(showBackground = true)
@Composable
private fun VerticalProductPrev() {
	VerticalProductItem()
}

@Preview(showBackground = true)
@Composable
private fun MarketProfileScreenPrev() {
	MarketProfileScreen()
}

@Preview(showBackground = true)
@Composable
private fun CartProductItemPrev() {
	CartProductItem(item = exampleItem)
}

@Preview(showBackground = true)
@Composable
private fun CartProductStatus() {
	PurchasedScreen()
}

@Preview(showBackground = true)
@Composable
private fun CartScreenPrev() {
	CartScreen()
}