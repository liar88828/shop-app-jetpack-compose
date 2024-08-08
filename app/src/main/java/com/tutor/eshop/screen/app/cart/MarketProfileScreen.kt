package com.tutor.eshop.screen.app.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tutor.eshop.R
import com.tutor.eshop.ui.theme.fontInter

@Composable
fun MarketProfileScreen(modifier: Modifier = Modifier) {
	Card {
		Row {

			Column(
				modifier.padding(15.dp),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.spacedBy(8.dp)
			) {
				Image(
					modifier = modifier
						.border(
							width = 1.dp,
							color = MaterialTheme.colorScheme.primary,
							shape = CircleShape
						)
						.background(
							color = MaterialTheme.colorScheme.primaryContainer, shape = CircleShape
						)
						.clip(shape = CircleShape),
					contentScale = ContentScale.Crop,
					painter = painterResource(R.drawable.ic_launcher_background),
					contentDescription = "title Market",
				)
				Text(
					text = "Market Profile",
					style = MaterialTheme.typography.titleLarge,
				)
				Row(

					horizontalArrangement = Arrangement.Center
				) {
					Icon(
						imageVector = Icons.Default.CheckCircle,
						contentDescription = "Icon New Releases",
						tint = MaterialTheme.colorScheme.primary
					)
					Text(
						text = "Official Store",
						style = MaterialTheme.typography.titleMedium,
						fontWeight = FontWeight.Normal

					)
				}
				Text(
					text = "Since February 10, 2020",
					style = MaterialTheme.typography.bodyMedium,
					fontWeight = FontWeight.Light
				)

			}
			Column(
				modifier.padding(15.dp),
				horizontalAlignment = Alignment.Start,
//				verticalArrangement = Arrangement.spacedBy(10.dp)
			) {

				MarketProfileStatic(size = "50 +", title = "Total Products")
				HorizontalDivider(
					modifier = modifier
						.padding(vertical = 10.dp)
						.size(width = 120.dp, height = 1.dp)
				)

				MarketProfileStatic(size = "4.5", title = "App Ratings")
				HorizontalDivider(
					modifier = modifier
						.padding(vertical = 10.dp)
						.size(width = 120.dp, height = 1.dp)
				)

				MarketProfileStatic(size = "50 +", title = "Cust. Reviews")
				HorizontalDivider(
					modifier = modifier
						.padding(vertical = 10.dp)
						.size(width = 120.dp, height = 1.dp)
				)

			}
		}
	}
}

@Composable
private fun MarketProfileStatic(modifier: Modifier = Modifier, size: String, title: String) {
	Column {
		Text(
			text = size,
			style = MaterialTheme.typography.headlineLarge,
			fontWeight = FontWeight.Bold
		)

		Text(
			text = title,
			style = MaterialTheme.typography.bodyMedium,
			fontWeight = FontWeight.Normal,
			fontFamily = fontInter
		)
	}

}
