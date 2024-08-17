package com.tutor.eshop.screen.app.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.eshop.data.model.EStoresItem
import com.tutor.eshop.screen.app.cart.component.TitleCard

@Composable
fun GridCategory(
	title: String,
	modifier: Modifier = Modifier,
	textButton: String,
	buttonAction: () -> Unit,
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
				.padding(10.dp)
				.height(280.dp),
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
			Row(modifier.fillMaxWidth()) {
				Column(modifier.weight(0.6f)) {
					CardGrid(
						"New Products",
						"123 Products",

						Color.Green.copy(0.4f),
						to = {},
						Modifier.fillMaxHeight(.5f)
					)
					CardGrid(
						"Discount",
						"10 Products",
						Color.Blue.copy(0.4f),
						to = {},

					)

				}
				Column(modifier.weight(0.4f)) {
					CardGrid(
						"Promotion",
						"41232 Products",

						color = Color.Magenta.copy(0.4f),
						modifier = Modifier
							.weight(1f)
						)

				}
			}

		}
	}
}

@Composable
private fun CardGrid(
	title: String,
	text: String,
	color: Color,
	to: () -> Unit = {},
	modifier: Modifier = Modifier,
) {
	Surface(
		onClick = to
	) {
		Card(
			modifier = modifier
				.fillMaxSize()
				.padding(5.dp),
			colors = CardDefaults.cardColors(containerColor = color)
		) {
			Column(
				modifier = Modifier
					.fillMaxSize()
					.padding(20.dp),
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally
			) {

				Text(
					text = title,
					style = MaterialTheme.typography.titleMedium,
					textAlign = TextAlign.Center,
					fontWeight = FontWeight.SemiBold
				)
				Text(
					text = text,
					style = MaterialTheme.typography.bodySmall,
					textAlign = TextAlign.Center,
					fontWeight = FontWeight.Light


				)
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun GridCategoryPrev() {
	GridCategory(
		title = "Categories",
		textButton = "See All",
		buttonAction = {},
	)
}