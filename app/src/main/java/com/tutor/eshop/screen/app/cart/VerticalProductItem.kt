package com.tutor.eshop.screen.app.cart

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tutor.eshop.R
import com.tutor.eshop.ui.theme.fontInter

@Composable
fun VerticalProductItem(modifier: Modifier = Modifier) {
	Card(
		elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
		colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary)
	) {
		Box(modifier.padding(5.dp)) {
			Image(
				painter = painterResource(id = R.drawable.ic_launcher_foreground),
				contentDescription = "title Product",
//				contentScale = ContentScale.Crop,
				modifier = modifier
					.size(160.dp)
					.background(
						color = MaterialTheme.colorScheme.primaryContainer,
						shape = MaterialTheme.shapes.medium
					)
			)

			Box(
				modifier = modifier
					.padding(5.dp)
					.align(Alignment.TopStart)
			) {

				Badge() {
					Text(
						modifier = modifier.padding(2.dp), text = "NEW", fontSize = 10.sp
					)
				}
			}

			Box(
				modifier = modifier
					.padding(5.dp)
					.align(Alignment.TopEnd), contentAlignment = Alignment.Center
			) {
				Badge {
					Row(
						modifier = modifier.padding(2.dp),
						horizontalArrangement = Arrangement.Center,
						verticalAlignment = Alignment.CenterVertically
					) {
						Icon(
							imageVector = Icons.Default.Star,
							contentDescription = "Icon New Releases",
							modifier = modifier.size(12.dp),
							tint = MaterialTheme.colorScheme.onPrimary
						)
						Text(text = "4.4", fontSize = 10.sp)
					}
				}
			}
			Box(
				modifier = modifier
					.align(Alignment.BottomEnd)
					.offset(
						x = (-10).dp, y = 20.dp
					)

			) {
				OutlinedIconButton(
					border = BorderStroke(
						width = 2.dp, color = MaterialTheme.colorScheme.onPrimary
					),
					onClick = {},
					colors = IconButtonDefaults.outlinedIconButtonColors(
						containerColor = MaterialTheme.colorScheme.primaryContainer,
						contentColor = MaterialTheme.colorScheme.primary,
					),
				) {
					Icon(
						imageVector = Icons.Default.Add, contentDescription = "Icon Add"
					)
				}
			}

		}
		Column(modifier = modifier.padding(10.dp)) {

			Text(
				text = "brand",
				style = MaterialTheme.typography.bodySmall,
				fontWeight = FontWeight.Thin,
				fontFamily = fontInter,
			)
			Text(
				text = "title Product",
				style = MaterialTheme.typography.titleMedium,
				fontWeight = FontWeight.SemiBold,
				fontFamily = fontInter
			)
			Text(
				text = "$1342.23",
				style = MaterialTheme.typography.bodyMedium,
				fontWeight = FontWeight.Bold,
				fontFamily = fontInter
			)
			Row(
				horizontalArrangement = Arrangement.spacedBy(5.dp)
			) {
				InputChip(shape = CircleShape, selected = false, onClick = {}, label = {
					Box(
						modifier = modifier
							.background(
								color = Color.Red, shape = CircleShape
							)
							.size(15.dp)
							.padding(2.dp)
					)
				})
				InputChip(shape = CircleShape, selected = false, onClick = {}, label = {
					Text(text = "M")
				})
			}
		}
	}
}

@Preview
@Composable
private fun VerticalProductItemPrev() {
	VerticalProductItem()
}