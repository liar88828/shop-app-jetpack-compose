package com.tutor.eshop.screen.app.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ProfileTopAppBar(
	scrollBehavior: TopAppBarScrollBehavior,
	modifier: Modifier,
	search: MutableState<String>
) {
	TopAppBar(
		scrollBehavior = scrollBehavior,
		navigationIcon = {
			IconAction({ /*TODO*/ }, Icons.Default.Settings, "Setting")
		},
		title = {},
		actions = {
			IconAction({ /*TODO*/ }, Icons.Default.Settings, "Setting")
			IconAction({ /*TODO*/ }, Icons.Default.ShoppingCart, "Trolley", 123)
			IconAction({ /*TODO*/ }, Icons.AutoMirrored.Filled.Message, "Message", 11)

		},
		colors = TopAppBarDefaults.topAppBarColors(
			containerColor = MaterialTheme.colorScheme.primaryContainer,
			titleContentColor = MaterialTheme.colorScheme.primary,
		),

		)
}

