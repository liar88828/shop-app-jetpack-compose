package com.tutor.eshop.screen.app.transaction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.eshop.data.model.exampleItem
import com.tutor.eshop.screen.app.cart.component.TitleCard
import com.tutor.eshop.screen.app.carts.CartProductItem
import com.tutor.eshop.ui.theme.fontInter

@Composable
fun PurchasedScreen(modifier: Modifier = Modifier) {
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
				title = "Shop",
				component = {
					FilterChip(
						onClick = {},
						shape = MaterialTheme.shapes.medium,
						label = { Text("Purchased") },
						selected = true,
						colors = FilterChipDefaults.filterChipColors(
							containerColor = MaterialTheme.colorScheme.primaryContainer,
							labelColor = MaterialTheme.colorScheme.primary,
							selectedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
							selectedLabelColor = MaterialTheme.colorScheme.onPrimary
						)
					)
				}
			)
//			Row(
//				modifier = modifier.fillMaxWidth(),
//				horizontalArrangement = Arrangement.SpaceBetween,
//				verticalAlignment = Alignment.CenterVertically
//			) {
//				Text(
//					text = "Shop",
//					fontFamily = fontInter,
//					style = MaterialTheme.typography.titleLarge,
//					fontWeight = FontWeight.Bold,
//				)
//
//				FilterChip(
//					onClick = {},
//					shape = MaterialTheme.shapes.medium,
//					label = { Text("Purchased") },
//					selected = true,
//					colors = FilterChipDefaults.filterChipColors(
//						containerColor = MaterialTheme.colorScheme.primaryContainer,
//						labelColor = MaterialTheme.colorScheme.primary,
//						selectedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
//						selectedLabelColor = MaterialTheme.colorScheme.onPrimary
//					)
//				)
//			}

			CartProductItem(
				item = exampleItem
			)

			Row(
				modifier = modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {

				Text(
					text = "Jul 28, 2024",
					fontFamily = fontInter,
					style = MaterialTheme.typography.titleMedium,
				)


				Button(
					onClick = {},
					shape = MaterialTheme.shapes.medium,
				) {
					Text(
						text = "Buy More",
						fontFamily = fontInter,
						style = MaterialTheme.typography.titleSmall,
						fontWeight = FontWeight.Bold
					)
				}
			}
		}
	}
}

@Preview
@Composable
private fun PurchasedScreenPrev() {
	PurchasedScreen()
}