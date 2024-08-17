package com.tutor.eshop.screen.app.component

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun IconAction(
	to: () -> Unit, icon: ImageVector, title: String,
	count: Int = 0,
	modifier: Modifier = Modifier,
) {
	BadgedBox(badge = {
		if (count > 0) {
			Badge(
//				modifier = modifier.align(Alignment.TopStart),
				containerColor = MaterialTheme.colorScheme.primary,
				contentColor = MaterialTheme.colorScheme.onPrimary
			) {
				Text("$count")
			}
		}
	}) {
		IconButton(onClick = to) {
			Icon(
				imageVector = icon,
				contentDescription = title
			)
		}
	}
}