package com.tutor.eshop.screen.app.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowOutward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardBanner(modifier: Modifier = Modifier) {

	Card(
		modifier = Modifier
			.fillMaxWidth()
			.padding(10.dp),
		colors = CardDefaults.cardColors(
			containerColor = MaterialTheme.colorScheme.primaryContainer
		)
	) {
		Row(
			modifier = modifier
				.fillMaxWidth()
				.padding(15.dp),
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically
		) {
			Column {
				Text(
					"World Shopping",
					style = MaterialTheme.typography.titleMedium,
				)
				Text(
					text = "Discounts & free shipping",
					style = MaterialTheme.typography.bodySmall
				)
			}
			IconButton(
				{},
				modifier.size(50.dp),
				colors = IconButtonDefaults.iconButtonColors(
					containerColor = MaterialTheme.colorScheme.primary,
					contentColor = MaterialTheme.colorScheme.onPrimary
				)
			) {
				Icon(
					imageVector = Icons.Default.ArrowOutward,
					contentDescription = "Arrow Outward"
				)
			}
		}
	}
}

@Preview
@Composable
private fun CardBannerPrev() {
	CardBanner()
}