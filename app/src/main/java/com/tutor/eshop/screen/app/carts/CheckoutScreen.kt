package com.tutor.eshop.screen.app.carts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.eshop.data.model.exampleItem
import com.tutor.eshop.screen.app.cart.component.TitleCard
import com.tutor.eshop.ui.theme.fontInter

@Composable
fun CheckoutScreen(
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

//			Row(
//				modifier = modifier.fillMaxWidth(),
//				horizontalArrangement = Arrangement.SpaceBetween,
//				verticalAlignment = Alignment.CenterVertically
//			) {
//				Text(
//					text = "Shop Cart",
//					fontFamily = fontInter,
//					style = MaterialTheme.typography.titleLarge,
//					fontWeight = FontWeight.Bold,
//				)
//
//				OutlinedIconButton(
//					onClick = {},
//
//					shape = MaterialTheme.shapes.medium
//				) {
//					Icon(imageVector = Icons.Default.Close, contentDescription = "Icon close")
//				}
//			}
			TitleCard(
				title = "Shop Cart",
				component = {
					OutlinedIconButton(
						onClick = {},
						shape = MaterialTheme.shapes.medium
					) {
						Icon(imageVector = Icons.Default.Close, contentDescription = "Icon close")
					}
				}
			)

			LazyColumn(
				verticalArrangement = Arrangement.spacedBy(2.dp)
			) {
				items(4) {
					CartProductItem(
						item = exampleItem
					)
				}
			}

			Button(
				onClick = onCheckOut,
				shape = MaterialTheme.shapes.medium,
				modifier = modifier.fillMaxWidth()
			) {
				Text(
					text = "Checkout : ( 10 )",
					fontFamily = fontInter,
					style = MaterialTheme.typography.titleSmall,
					fontWeight = FontWeight.Bold
				)

			}
		}
	}
}

@Preview
@Composable
private fun CartScreenPrev() {
	CheckoutScreen({})
}