package com.tutor.eshop.screen.app.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.eshop.screen.app.cart.component.TitleCard

@Composable
fun ListRowProductScreen(modifier: Modifier = Modifier) {
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
					TextButton(onClick = {}) {
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
				items(6) {
					VerticalProductItem()
				}
			}
		}
	}
}

@Preview
@Composable
private fun ListRowProductScreenPrev() {
	ListRowProductScreen()
}