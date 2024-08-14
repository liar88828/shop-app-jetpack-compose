package com.tutor.eshop.screen.app.carts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.eshop.data.model.EStoresItem
import com.tutor.eshop.data.model.exampleItem
import com.tutor.eshop.screen.app.cart.component.TitleCard

@Composable
fun CheckoutScreen(
	products: List<EStoresItem>,
	onCheckOut: () -> Unit,
	modifier: Modifier = Modifier
) {
	ElevatedCard(
		modifier = modifier.fillMaxWidth(),
		elevation = CardDefaults.cardElevation(4.dp),
		colors = CardDefaults.cardColors(
//			containerColor = MaterialTheme.colorScheme.onPrimary
		)
	) {
		Column(
			modifier = modifier
				.fillMaxWidth()
				.padding(15.dp),
			verticalArrangement = Arrangement.spacedBy(8.dp)
		) {
			TitleCard(
				title = "Shop Cart",
				component = {
				}
			)
			LazyColumn(
				verticalArrangement = Arrangement.spacedBy(8.dp),
//				modifier = modifier.height(650.dp)
			) {
				items(products) { CartProductItemCount(it) }

			}
//			Button(
//				onClick = onCheckOut,
//				shape = MaterialTheme.shapes.medium,
//				modifier = modifier.fillMaxWidth()
//			) {
//				Text(
//					text = "Checkout : ( 10 )",
//					fontFamily = fontInter,
//					style = MaterialTheme.typography.titleSmall,
//					fontWeight = FontWeight.Bold
//				)
//			}
		}
	}
}

@Preview
@Composable
private fun CartScreenPrev() {
	CheckoutScreen(
		onCheckOut = {},
		products = listOf(exampleItem),
	)
}