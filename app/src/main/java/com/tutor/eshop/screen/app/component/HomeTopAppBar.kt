package com.tutor.eshop.screen.app.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeTopAppBar(
	scrollBehavior: TopAppBarScrollBehavior,
	modifier: Modifier,
	search: MutableState<String>
) {
	TopAppBar(
		scrollBehavior = scrollBehavior,
		title = {
			OutlinedTextField(

				minLines = 2,
				modifier = modifier
					.fillMaxWidth()
					.height(50.dp)
					.padding(horizontal = 5.dp),
				shape = MaterialTheme.shapes.extraLarge,
				value = search.value,
				onValueChange = { search.value = it },
//						label={ Text("Search")},
				leadingIcon = {
					IconButton(
						onClick = {},
						colors = IconButtonDefaults.iconButtonColors(
							containerColor = MaterialTheme.colorScheme.primary,
							contentColor = MaterialTheme.colorScheme.onPrimary
						)
					) {
						Icon(
							imageVector = Icons.Default.Search,
							contentDescription = "Search Icon"
						)
					}
				},
				placeholder = {
					Column(
						modifier.size(200.dp, 50.dp)
					) {
						Text(
							"Search on Electric ....",
							fontWeight = FontWeight.Medium,
							fontSize = 14.sp,
							modifier = modifier,
							lineHeight = 2.sp
						)
//								Text(
//									"Electric - Shoes - Anything",
//									fontWeight = FontWeight.Light,
//									fontSize = 12.sp,
//									modifier = modifier,
//									lineHeight = 2.sp
//
//								)
					}
				},

				)
		},
		actions = {
			IconButton(onClick = { /*TODO*/ }) {
				Icon(
					imageVector = Icons.Default.Menu,
					contentDescription = "Menu"
				)
			}
		},
		colors = TopAppBarDefaults.topAppBarColors(
			containerColor = MaterialTheme.colorScheme.primaryContainer,
			titleContentColor = MaterialTheme.colorScheme.primary,
		),

		)
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SearchTopAppBar(
	scrollBehavior: TopAppBarScrollBehavior,
	modifier: Modifier,
	search: MutableState<String>
) {
	var onSearch by remember {
		mutableStateOf(false)
	}

	CenterAlignedTopAppBar(
		navigationIcon = {
			IconButton({}) {
				Icon(
					imageVector = Icons.Default.ArrowBackIosNew,
					contentDescription = "Back Back"
				)
			}
		},
		scrollBehavior = scrollBehavior,
		title = {
			if (onSearch) {
				OutlinedTextField(
					minLines = 2,
					modifier = modifier
						.fillMaxWidth()
						.height(50.dp)
						.padding(horizontal = 5.dp),
					shape = MaterialTheme.shapes.extraLarge,
					value = search.value,
					onValueChange = { search.value = it },
					leadingIcon = {
						IconButton(
							onClick = {},
							colors = IconButtonDefaults.iconButtonColors(
								containerColor = MaterialTheme.colorScheme.primary,
								contentColor = MaterialTheme.colorScheme.onPrimary
							)
						) {
							Icon(
								imageVector = Icons.Default.Search,
								contentDescription = "Search Icon"
							)
						}
					},
					placeholder = {
						Column(
							modifier.size(200.dp, 50.dp)
						) {
							Text(
								"Search on Electric ....",
								fontWeight = FontWeight.Medium,
								fontSize = 14.sp,
								modifier = modifier,
								lineHeight = 2.sp
							)
//								Text(
//									"Electric - Shoes - Anything",
//									fontWeight = FontWeight.Light,
//									fontSize = 12.sp,
//									modifier = modifier,
//									lineHeight = 2.sp
//
//								)
						}
					},
				)
			} else {
				Text(
					"Search ",
					fontWeight = FontWeight.Medium,
					fontSize = 20.sp,
					modifier = modifier,
				)
			}
		},
		actions = {
			IconButton(onClick = { onSearch = !onSearch }) {
				Icon(
					imageVector = Icons.Default.Search,
					contentDescription = "Search Icon"
				)
			}
		},
		colors = TopAppBarDefaults.topAppBarColors(
			containerColor = MaterialTheme.colorScheme.primaryContainer,
			titleContentColor = MaterialTheme.colorScheme.primary,
		),

		)
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CartsTopAppBar(
	scrollBehavior: TopAppBarScrollBehavior,
	modifier: Modifier,
	search: MutableState<String>
) {
	CenterAlignedTopAppBar(
		navigationIcon = {
			IconButton({}) {
				Icon(
					imageVector = Icons.Default.ArrowBackIosNew,
					contentDescription = "Back Icon"
				)
			}
		},
		scrollBehavior = scrollBehavior,
		title = { Text("Carts ") },
		actions = {
			IconButton(onClick = { /*TODO*/ }) {
				Icon(
					imageVector = Icons.Default.Menu,
					contentDescription = "Menu"
				)
			}
		},
		colors = TopAppBarDefaults.topAppBarColors(
			containerColor = MaterialTheme.colorScheme.primaryContainer,
			titleContentColor = MaterialTheme.colorScheme.primary,
		),
	)
}

