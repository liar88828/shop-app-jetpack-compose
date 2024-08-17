package com.tutor.eshop.screen.app.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tutor.eshop.R

@Composable
@OptIn(ExperimentalLayoutApi::class)
fun BioDataProfile(modifier: Modifier) {
	Card {
		Row(
			modifier = modifier
				.fillMaxWidth()
				.padding(10.dp),
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			Image(
				painter = painterResource(R.drawable.ic_launcher_foreground),
				contentDescription = "Profile",
				modifier = modifier
					.size(60.dp)
					.clip(CircleShape),

				)
			Column(
				verticalArrangement = Arrangement.spacedBy(5.dp),
			) {
				Text(
					"Florence Bala Anton Aliyah",
					style = MaterialTheme.typography.titleMedium,
					fontWeight = FontWeight.Bold
				)

				FlowRow(
					horizontalArrangement = Arrangement.spacedBy(5.dp),
					maxItemsInEachRow = 2
				) {

					Text(
						"White List ${100}",
						style = MaterialTheme.typography.bodySmall
					)
					Text(
						"Market Follow ${100}",
						style = MaterialTheme.typography.bodySmall
					)
					Text(
						"Vouchers ${100}",
						style = MaterialTheme.typography.bodySmall
					)
				}
			}
			IconButton(
				{}
			) {
				Icon(
					imageVector = Icons.Default.Settings,
					contentDescription = "Icon Setting"
				)
			}
		}
	}
}