package com.tutor.eshop.screen.app.profile

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
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.tutor.eshop.screen.app.cart.component.TitleCard

@Composable
fun HistoryStatus(modifier: Modifier = Modifier) {
	Card {
		Column(modifier = modifier.padding(10.dp)) {

			TitleCard(
				title = "History",
				component = {
					TextButton(
						onClick = {},
						modifier = modifier.size(height = 20.dp, width = 90.dp),
						contentPadding = PaddingValues(0.dp)
					) {
						Text(text = "See All")
					}
				})
			LazyRow(
				contentPadding = PaddingValues(vertical = 10.dp),
				horizontalArrangement = Arrangement.spacedBy(10.dp)
			) {
				items(exampleHistory) {
					Card(
						modifier.fillMaxWidth(),
						colors = CardDefaults.cardColors(
							containerColor = MaterialTheme.colorScheme.primary
						)
					) {
						Row(
							modifier = modifier
								.fillMaxWidth()
								.padding(horizontal = 20.dp, vertical = 10.dp),
							verticalAlignment = Alignment.CenterVertically
						) {
							IconButton(
								{},
								colors = IconButtonDefaults.iconButtonColors(
									containerColor = statusColor(it.status)
								)
							) {

								Icon(
									imageVector = statusIcon(it.status),
									contentDescription = it.status.name,
									modifier.padding(10.dp),

									)
							}
							Column(modifier.padding(10.dp)) {
								Text(
									"To : ${it.to}",
									style = MaterialTheme.typography.titleMedium
								)
								Text(
									it.product,
									style = MaterialTheme.typography.bodySmall

								)
							}
							Text(
								text = " $${it.price}",
								style = MaterialTheme.typography.titleLarge
							)
						}
					}
				}
			}
		}
	}
}

fun statusIcon(status: STATUS): ImageVector {
	return when (status) {
		STATUS.SUCCESS -> Icons.Default.Check
		STATUS.FAIL -> Icons.Default.Cancel
		STATUS.PROCESS -> Icons.Default.Sync
	}
}

fun statusColor(status: STATUS): Color {
	return when (status) {
		STATUS.SUCCESS -> Color.Green.copy(0.4f)
		STATUS.FAIL -> Color.Red.copy(0.4f)
		STATUS.PROCESS -> Color.Yellow.copy(0.4f)
	}
}

data class History(
	val to: String,
	val product: String,
	val price: Int,
	val status: STATUS
)

enum class STATUS {
	SUCCESS,
	FAIL,
	PROCESS

}

val exampleHistory = listOf(
	History(
		to = "Richard Mia",
		product = "Manoj Vasquez pizza",
		price = 2000,
		status = STATUS.SUCCESS
	),
	History(
		to = "Lucia Ramadan",
		product = "Kyaw Bauri Snack",
		price = 2000,
		status = STATUS.FAIL
	),
)


