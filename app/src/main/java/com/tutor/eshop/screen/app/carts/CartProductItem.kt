package com.tutor.eshop.screen.app.carts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tutor.eshop.R
import com.tutor.eshop.data.model.EStoresItem
import com.tutor.eshop.data.model.exampleItem
import com.tutor.eshop.ui.theme.fontInter

@Composable
fun CartProductItem(
	item: EStoresItem,
	modifier: Modifier = Modifier
) {

	ElevatedCard(
		modifier = modifier
			.height(130.dp)
			.padding(3.dp),
		elevation = CardDefaults.cardElevation(1.dp),

		) {
		Row(
			modifier = modifier.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically
		) {
			Image(
				painter = painterResource(id = R.drawable.ic_launcher_foreground),
				contentDescription = "title Product",
				modifier
					.padding(8.dp)
					.background(
						color = MaterialTheme.colorScheme.primaryContainer,
						shape = MaterialTheme.shapes.medium
					)
			)
			Column(
				modifier
					.fillMaxHeight()
					.padding(start = 4.dp, end = 20.dp)
					.padding(vertical = 10.dp),
				verticalArrangement = Arrangement.SpaceBetween
			) {
				//brand
				Text(
					text = item.category,
					maxLines = 1,
					overflow = TextOverflow.Ellipsis,
					style = MaterialTheme.typography.bodySmall,

					)
				//name
				Text(
					text = item.title,
					style = MaterialTheme.typography.titleSmall,
					fontWeight = FontWeight.Bold,
					maxLines = 2,
					overflow = TextOverflow.Ellipsis,
				)
				Row(
					modifier
						.fillMaxWidth()
						.padding(0.dp),
					horizontalArrangement = Arrangement.SpaceBetween,
					verticalAlignment = Alignment.CenterVertically
				) {
					// color list and
					Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
						ColorChipItem(Color.Red)
						SizeChipItem("M")
					}
					// price
					Text(
						text = "$${item.price}",
						style = MaterialTheme.typography.titleMedium,
						fontWeight = FontWeight.Bold,
						fontFamily = fontInter,
					)
				}
			}
		}
	}
}

@Composable
private fun ColorChipItem(color: Color) {
	InputChip(
		selected = false,
		onClick = {},
		modifier = Modifier.size(35.dp),
		label = {
			Box(
				modifier = Modifier

					.background(color = color, shape = CircleShape)
					.size(15.dp)
			)
		},
	)
}

@Composable
private fun SizeChipItem(title: String) {
	InputChip(
		onClick = {},
		modifier = Modifier.size(35.dp),
		label = {
			Text(
				text = title,
				style = MaterialTheme.typography.titleMedium,
				fontSize = 15.sp
			)
		},
		selected = false,
	)
}

@Preview
@Composable
private fun CartProductItemPrev() {
	CartProductItem(
		item = exampleItem
	)

}