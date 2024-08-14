package com.tutor.eshop.screen.app.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.eshop.data.model.EStoresItem
import com.tutor.eshop.data.model.exampleItem
import com.tutor.eshop.data.model.exampleItem2
import com.tutor.eshop.screen.app.carts.CartProductItem

@Composable
fun CardHorizontal(
	products: List<EStoresItem>,
	modifier: Modifier = Modifier
) {
	Card(
		modifier
			.fillMaxWidth()
			.padding(10.dp)
	) {
		Column(modifier.padding(10.dp)) {
			Row(
				modifier
					.fillMaxWidth()
					.padding(5.dp),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Row {
					IconButton(
						{},
						colors = IconButtonDefaults.outlinedIconButtonColors(
							containerColor = MaterialTheme.colorScheme.primary,
							contentColor = MaterialTheme.colorScheme.onPrimary
						),
						modifier = modifier
							.padding(end = 5.dp)
							.size(30.dp)
					) {
						Icon(
							imageVector = Icons.Default.CameraAlt,
							contentDescription = "Camera Icon",
							modifier = modifier
								.size(20.dp)
						)
					}
					Column {
						Text(
							text = "Electronic",
							style = MaterialTheme.typography.bodySmall,
							fontWeight = FontWeight.Light
						)
						Text(
							text = "Gadget Day",
							style = MaterialTheme.typography.titleSmall
						)
					}
				}
				TextButton(
					{},
					modifier.size(height = 20.dp, width = 90.dp),
					contentPadding = PaddingValues(0.dp)
				) {
					Text(text = "Show All")
				}
			}
			LazyRow(
				horizontalArrangement = Arrangement.spacedBy(10.dp)
			) {
				items(products) { CartProductItem(it) }
			}
		}
	}
}

@Preview
@Composable
private fun CardHorizontalPrev() {
	CardHorizontal(listOf(exampleItem, exampleItem2))

}