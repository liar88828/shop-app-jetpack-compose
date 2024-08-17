package com.tutor.eshop.screen.app.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.EmojiEvents
import androidx.compose.material.icons.outlined.Redeem
import androidx.compose.material.icons.outlined.Sell
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tutor.eshop.screen.app.cart.component.TitleCard

@Composable
fun RewardedDiscounts(modifier: Modifier = Modifier) {
	Card {
		Column(
			modifier = modifier
				.fillMaxWidth()
				.padding(10.dp),
			verticalArrangement = Arrangement.spacedBy(10.dp)
		) {

			TitleCard(
				title = "Rewarded and Discounts",
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
				horizontalArrangement = Arrangement.spacedBy(20.dp)
			) {
				items(exampleRewardedData) {
					CardRewarded(it, modifier)
				}
			}
		}
	}
}

@Composable
fun CardRewarded(
	it: RewardedData,
	modifier: Modifier
) {
	Card(
		colors = CardDefaults.cardColors(
			containerColor = it.color
		)
	) {
		Column(modifier.padding(20.dp)) {
			Icon(
				imageVector = it.icon,
				contentDescription = it.title,
				modifier = modifier
					.size(60.dp)
			)
			Text(
				it.title,
				style = MaterialTheme.typography.titleMedium,
				fontWeight = FontWeight.Bold
			)
			Text(
				it.description,
				style = MaterialTheme.typography.bodySmall
			)
		}
	}
}

data class RewardedData(
	val icon: ImageVector,
	val title: String,
	val description: String,
	val color: androidx.compose.ui.graphics.Color,
)

val exampleRewardedData = listOf(
	RewardedData(
		icon = Icons.Outlined.EmojiEvents,
		title = "Achievement",
		description = "200 Reward",
		color = Yellow.copy(alpha = 0.4f)
	),
	RewardedData(
		icon = Icons.Outlined.Sell,
		title = "Offers 30%",
		description = "Click to detail",
		color = Blue.copy(alpha = 0.4f)
	),
	RewardedData(
		icon = Icons.Outlined.Redeem,
		title = "Rewards",
		description = "29 Reward",
		color = Green.copy(alpha = 0.4f)
	)
)
