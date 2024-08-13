package com.tutor.eshop.screen.app.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.eshop.data.model.EStoresItem
import com.tutor.eshop.data.model.exampleItem
import com.tutor.eshop.screen.app.cart.component.TitleCard

@Composable
fun ListRowProductScreen(
	title: String,
	modifier: Modifier = Modifier,
	textButton: String,
	buttonAction: () -> Unit,
	list: List<EStoresItem>
) {
	Card(
		modifier = modifier.fillMaxWidth(),
		colors = CardDefaults.cardColors(
			containerColor = Color.Transparent
		)

	) {
		Column(
			modifier = modifier
				.fillMaxWidth()
				.padding(15.dp)
				.height(320.dp),
			verticalArrangement = Arrangement.spacedBy(8.dp)
		) {

			TitleCard(
				title = title,
				component = {
					TextButton(
						onClick = buttonAction,
						modifier = modifier.size(height = 20.dp, width = 90.dp),
						contentPadding = PaddingValues(0.dp)
					) {
						Text(text = textButton)
					}
				})

//			Text(
//				text = "New Products", style = MaterialTheme.typography.titleLarge
//			)
//			TextButton({}) {
//				Text(text = "See All")
//			}
			LazyRow(
//				modifier = modifier.padding(10.dp),
				horizontalArrangement = Arrangement.spacedBy(15.dp)
			) {
				items(list) { VerticalProductItem(it) }
			}
		}
	}
}

@Composable
fun ListRowProductScreenBackground(
	products: List<EStoresItem>,
	modifier: Modifier = Modifier
) {
	Card(
		modifier = modifier.fillMaxWidth()
	) {
		Column(
			modifier = modifier
				.fillMaxWidth()
				.padding(15.dp),
			verticalArrangement = Arrangement.spacedBy(8.dp)
		) {

			TitleCard(
				title = "Summary",
				component = {
					TextButton(
						onClick = {},
						modifier = modifier.size(height = 20.dp, width = 90.dp),
						contentPadding = PaddingValues(0.dp)
					) {
						Text(text = "See All")
					}
				})

//			Text(
//				text = "New Products", style = MaterialTheme.typography.titleLarge
//			)
//			TextButton({}) {
//				Text(text = "See All")
//			}
			LazyRow(
//				modifier = modifier.padding(10.dp),
				horizontalArrangement = Arrangement.spacedBy(15.dp)
			) {
				items(products) { VerticalProductItem(it) }
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun ListRowProductScreenPrev() {
	ListRowProductScreen(
		title = "New Products",
		textButton = "See All",
		buttonAction = {}, list = listOf(exampleItem)

	)
}