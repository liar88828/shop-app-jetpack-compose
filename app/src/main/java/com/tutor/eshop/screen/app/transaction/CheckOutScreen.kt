package com.tutor.eshop.screen.app.transaction

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.eshop.screen.app.cart.component.CheckoutItem
import com.tutor.eshop.screen.app.cart.component.RowText
import com.tutor.eshop.screen.app.cart.component.TitleCard
import com.tutor.eshop.ui.theme.fontInter

@Composable
fun CheckOutScreen(
	onClick: () -> Unit,
	modifier: Modifier = Modifier
) {
	Card(
		modifier
			.fillMaxWidth()
			.padding(horizontal = 20.dp)
	) {
		Column(
			modifier = modifier
				.fillMaxWidth()
				.padding(15.dp),
			verticalArrangement = Arrangement.spacedBy(8.dp)

		) {
			TitleCard(
				title = "Summary",
				component = {
					OutlinedIconButton(
						modifier = modifier.size(30.dp),
						onClick = onClick,
						shape = MaterialTheme.shapes.medium,
						border = BorderStroke(
							width = 1.dp, color = MaterialTheme.colorScheme.primary
						),
						colors = IconButtonDefaults.outlinedIconButtonColors(
							containerColor = MaterialTheme.colorScheme.primaryContainer,
						)
					) {
						Icon(
							imageVector = Icons.Default.MoreHoriz,
							contentDescription = "Icon More"
						)
					}
				})

			CheckoutItem(title = "Detail Total", content = {
				RowText(title = "Price Total", price = 200)
				RowText(title = "Product Protection", price = 2)
				RowText(title = "Delivery Fee", price = 20)
				RowText(title = "Insurance Fee", price = 8)
			})
//			------------

			CheckoutItem(title = "Payment Method", content = {
				RowText(title = "Service Fee", price = 30)
				RowText(title = "Application Fee", price = 5)
			})
			CheckoutItem(title = "Total", content = {
				Row(
					modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceBetween,
					verticalAlignment = Alignment.CenterVertically
				) {
					Text(
						text = "Total Payment",
						style = MaterialTheme.typography.bodyMedium,
						fontWeight = FontWeight.SemiBold,
						fontFamily = fontInter
					)
					Text(
						text = "$400",
						style = MaterialTheme.typography.bodySmall,
						fontWeight = FontWeight.SemiBold,
						fontFamily = fontInter
					)
				}
			})
			//------

		}
	}
}

@Preview
@Composable
private fun CheckOutScreenPrev() {
	CheckOutScreen({})
}