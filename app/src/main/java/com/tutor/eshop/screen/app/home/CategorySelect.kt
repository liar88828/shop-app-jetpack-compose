package com.tutor.eshop.screen.app.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.tooling.preview.Preview
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
	Column(
		modifier = modifier.padding(horizontal = 10.dp),
	) {
		LazyRow(
			modifier = modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.spacedBy(10.dp)
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
}

@Composable
private fun ChipItem(
	title: String,
	onClick: () -> Unit,
	select: Boolean = false,
	modifier: Modifier = Modifier
) {
	FilterChip(
		shape = MaterialTheme.shapes.medium,
		onClick = onClick,
		label = { Text(title) },
		selected = select
	)
}

@Preview(showBackground = true)
@Composable
private fun CategorySelectPrev() {
	CategorySelect()
}