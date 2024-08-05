package com.tutor.eshop.screen.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun RowScope.MyNavigationBarItem(title: String, icon: ImageVector) {
	NavigationBarItem(onClick = { /*TODO*/ },
		label = { Text(text = title) },
		selected = true,
		icon = {
			Icon(
				imageVector = icon,
				contentDescription = title
			)
		})
}