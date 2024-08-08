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
fun TitleCard(
	component: @Composable () -> Unit,
	title: String,
	modifier: Modifier = Modifier,
) {
	Row(
		modifier.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(
			text = title,
			style = MaterialTheme.typography.titleLarge,
			fontWeight = FontWeight.Bold,
			fontFamily = fontInter
		)
		component()

	}
}