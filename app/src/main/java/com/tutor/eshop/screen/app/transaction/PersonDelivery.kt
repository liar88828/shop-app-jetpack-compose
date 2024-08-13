package com.tutor.eshop.screen.app.transaction

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tutor.eshop.ui.theme.fontInter

@Composable
fun PersonDelivery(modifier: Modifier = Modifier) {
	Card(
		modifier.fillMaxWidth()
	) {
		Column(
			modifier = modifier
				.fillMaxWidth()
				.padding(15.dp),
			verticalArrangement = Arrangement.spacedBy(8.dp)
		) {

			Row(
				modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Row(
					horizontalArrangement = Arrangement.spacedBy(4.dp)
				) {
					VerticalDivider(
						modifier.size(height = 24.dp, width = 1.dp),
						thickness = 2.dp,
						color = MaterialTheme.colorScheme.primary
					)
					Text(
						text = "Delivery",
						style = MaterialTheme.typography.titleLarge,
						fontWeight = FontWeight.Bold,
						fontFamily = fontInter
					)
				}
				OutlinedIconButton(
					modifier = modifier.size(30.dp),
					onClick = {},
					shape = MaterialTheme.shapes.medium,
					border = BorderStroke(
						width = 1.dp, color = MaterialTheme.colorScheme.primary
					),
					colors = IconButtonDefaults.outlinedIconButtonColors(
						containerColor = MaterialTheme.colorScheme.primaryContainer,
					)
				) {
					Icon(imageVector = Icons.Default.MoreHoriz, contentDescription = "Icon More")
				}
			}

			Card(
				colors = CardDefaults.cardColors(
					containerColor = MaterialTheme.colorScheme.primaryContainer
				)
			) {
				Column(modifier = modifier.padding(5.dp)) {
					Row(
						modifier = modifier

							.padding(5.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)
					) {
						Row(verticalAlignment = Alignment.CenterVertically) {
							Icon(
								imageVector = Icons.Default.Person,
								contentDescription = "Icon Person"
							)
							Text(
								text = "Rajendra Rodriguez", fontWeight = FontWeight.SemiBold
							)
						}
						VerticalDivider(modifier.size(height = 24.dp, width = 1.dp))
						Row(verticalAlignment = Alignment.CenterVertically) {
							Icon(
								imageVector = Icons.Default.Phone,
								contentDescription = "Icon Person"
							)
							Text(
								text = "+628123456789", fontWeight = FontWeight.SemiBold
							)
						}
					}
					Text(
						text = "deserunt urna tincidunt falli primis fusce fames torquent eu contentiones cursus delectus partiendo nascetur dicunt an ridens comprehensam oratio hinc intellegat te detracto ubique iriure eu menandri tacimates veri ligula nulla populo noster possim rutrum autem primis noluisse ultrices reque",
						fontWeight = FontWeight.Light,
						fontFamily = fontInter,
						style = MaterialTheme.typography.bodySmall,
						modifier = modifier.padding(horizontal = 10.dp)
					)
				}
			}

			Row(
				modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Row(
					verticalAlignment = Alignment.CenterVertically,

					) {
					Icon(
						imageVector = Icons.Default.LocationOn,
						contentDescription = "Icon Location",
						modifier = modifier.size(30.dp),
						tint = MaterialTheme.colorScheme.primary
					)
					Column {
						Text(
							text = "Google Maps On", color = MaterialTheme.colorScheme.primary
						)
						Text(
							text = "Jakarta, Indonesia", color = MaterialTheme.colorScheme.primary

						)
					}
				}
				Button(
					{},
					shape = MaterialTheme.shapes.medium,
				) {
					Text(text = "Change")
				}
			}
		}
	}
}