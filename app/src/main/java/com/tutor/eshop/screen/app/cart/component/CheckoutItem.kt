package com.tutor.eshop.screen.app.cart.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CheckoutItem(
	title: String, content: @Composable ColumnScope.() -> Unit, modifier: Modifier = Modifier
) {
	Card(
		colors = CardDefaults.cardColors(
			containerColor = MaterialTheme.colorScheme.onPrimary
		), elevation = CardDefaults.cardElevation(
			defaultElevation = 1.dp
		)
	) {
		Column(modifier.padding(8.dp)) {
			Text(
				text = title,
				style = MaterialTheme.typography.titleSmall,
				modifier = modifier.padding(5.dp)
			)
			Card(
				colors = CardDefaults.cardColors(
					containerColor = MaterialTheme.colorScheme.primary.copy(
						0.1f
					)
				)
			) {
				Column(
					modifier = modifier.padding(8.dp),
					verticalArrangement = Arrangement.spacedBy(8.dp),
					content = content
				)
			}
		}
	}
}