package com.tutor.eshop.screen.app.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val listCategory = listOf(
	"Promo",
	"Best Deals",
	"Windy Basic",
	"Spot",
	"New",
	"Discount",
	"Best Seller"
)

@Composable
fun CategorySelect(
	modifier: Modifier = Modifier,
//	setSelect:MutableState<String>,
) {
	val select = remember {
		mutableStateOf("")
	}
	LazyRow(
		modifier = modifier.fillMaxWidth(),
		contentPadding = PaddingValues(10.dp)
	) {
		items(listCategory) {
			ChipItem(
				title = it,
				onClick = { select.value = it },
				select = select.value == it
			)
		}
	}
}

@Composable
private fun ChipItem(
	title: String,
	onClick: () -> Unit,
	select: Boolean = false,
	modifier: Modifier = Modifier
) {
	FilterChip(
		modifier = modifier.padding(horizontal = 4.dp),
		shape = MaterialTheme.shapes.medium,
		onClick = onClick,
		label = { Text(title) },
		selected = select
	)
}
