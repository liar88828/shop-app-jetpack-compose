package com.tutor.eshop.screen.app.search

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tutor.eshop.screen.app.home.CategorySelect

@Composable
fun SortFilterSearch(
	showBottomSheet: MutableState<Boolean>,
	modifier: Modifier = Modifier,
) {
	Row(
		modifier.fillMaxWidth()
	) {
		CategorySelect(modifier.weight(0.9f))
		IconButton(
			{ showBottomSheet.value = true },
			modifier
				.weight(0.1f)
				.padding(2.dp)
		) {
			Icon(
				imageVector = Icons.AutoMirrored.Filled.Sort,
				contentDescription = "Icon Sort"
			)
		}
	}
}