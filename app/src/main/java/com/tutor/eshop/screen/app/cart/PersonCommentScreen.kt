package com.tutor.eshop.screen.app.cart

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tutor.eshop.R

@Composable
fun PersonCommentScreen(modifier: Modifier = Modifier) {
	Card(
	) {
		Column(
			modifier = modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
		) {

			Row(
				modifier = modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
			) {
				Row {
					Image(
						painter = painterResource(id = R.drawable.ic_launcher_foreground),
						contentDescription = "title Product",
						modifier
							.clip(CircleShape)
							.size(50.dp)
							.background(
								color = MaterialTheme.colorScheme.primaryContainer,
							)
					)
					Column(
						modifier = modifier.padding(horizontal = 10.dp),
					) {
						Text(
							text = "Rajendra Rodriguez", style = MaterialTheme.typography.titleLarge
						)
						Spacer(modifier.height(5.dp))
						Text(
							text = "2 days ago",
							style = MaterialTheme.typography.bodySmall,
							fontWeight = FontWeight.Light
						)
					}
				}
				Row {
					OutlinedIconButton(
						{},
						modifier = modifier.padding(2.dp),
						border = BorderStroke(
							width = 1.dp,
							color = MaterialTheme.colorScheme.primary,
						),
						colors = IconButtonDefaults.outlinedIconButtonColors(
							containerColor = MaterialTheme.colorScheme.primaryContainer,
							contentColor = MaterialTheme.colorScheme.primary,
						),
					) {
						Icon(
							imageVector = Icons.AutoMirrored.Filled.Message,
							contentDescription = "Icon Message",
							tint = MaterialTheme.colorScheme.primary
						)
					}
					OutlinedIconButton(
						{},
						modifier = modifier.padding(2.dp),
						border = BorderStroke(
							width = 1.dp,
							color = MaterialTheme.colorScheme.primary,
						),
						colors = IconButtonDefaults.outlinedIconButtonColors(
							containerColor = MaterialTheme.colorScheme.primaryContainer,
							contentColor = MaterialTheme.colorScheme.primary,
						),
					) {
						Icon(
							imageVector = Icons.Default.MoreHoriz,
							contentDescription = "Icon More",
							tint = MaterialTheme.colorScheme.primary

						)
					}
				}
			}

			Row(
				modifier = modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.spacedBy(10.dp),
				verticalAlignment = Alignment.CenterVertically
			) {
				Badge(
				) {
					Icon(
						imageVector = Icons.Default.Star,
						contentDescription = "Icon Star",
						modifier = modifier.size(12.dp)
					)
					Text(text = "4.5")

				}

				Text(
					text = "4 Photos",
					style = MaterialTheme.typography.bodySmall,
					fontWeight = FontWeight.Light
				)

				Text(
					text = "5 Discussion",
					style = MaterialTheme.typography.bodySmall,
					fontWeight = FontWeight.Light
				)
			}

			Text(text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren,")

			LazyRow(
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.spacedBy(8.dp)
			) {
				items(3) {
					Image(
						painter = painterResource(id = R.drawable.ic_launcher_foreground),
						contentDescription = "title Product",
						modifier
							.clip(MaterialTheme.shapes.medium)
							.size(80.dp)
							.background(color = MaterialTheme.colorScheme.primaryContainer)

					)
				}
				item() {
					IconButton({}) {
						Icon(
							imageVector = Icons.Default.Add,
							contentDescription = "Icon Add",
							tint = MaterialTheme.colorScheme.primary
						)
					}
				}
			}
		}
	}
}