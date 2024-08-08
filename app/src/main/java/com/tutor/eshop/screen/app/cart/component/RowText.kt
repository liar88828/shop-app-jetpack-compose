package com.tutor.eshop.screen.app.cart.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.tutor.eshop.ui.theme.fontInter

@Composable
fun RowText(modifier: Modifier = Modifier, title: String, price: Int) {
	Row(
		modifier.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(
			text = title,
			style = MaterialTheme.typography.bodySmall,
			fontWeight = FontWeight.SemiBold,
			fontFamily = fontInter
		)
		Text(
			text = "$${price}",
			style = MaterialTheme.typography.bodySmall,
			fontWeight = FontWeight.SemiBold,
			fontFamily = fontInter
		)
	}
}