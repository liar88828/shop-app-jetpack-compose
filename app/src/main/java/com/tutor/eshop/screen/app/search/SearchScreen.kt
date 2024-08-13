package com.tutor.eshop.screen.app.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tutor.eshop.screen.app.component.MyBottomAppBar
import com.tutor.eshop.screen.app.component.SearchTopAppBar
import com.tutor.eshop.screen.app.home.CategorySelect
import com.tutor.eshop.screen.app.home.MyLazyVerticalGrid
import com.tutor.eshop.viewmodel.eshop.EShopEvent
import com.tutor.eshop.viewmodel.eshop.EShopState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
	navController: NavHostController,
	state: EShopState,
	onEvent: (EShopEvent) -> Unit,
	modifier: Modifier = Modifier,
) {
	val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
		rememberTopAppBarState()
	)

	val search = remember {
		mutableStateOf("")
	}
	var showBottomSheet by remember {
		mutableStateOf(false)
	}
	val sheetState = rememberModalBottomSheetState()
	val scope = rememberCoroutineScope()

	LaunchedEffect(key1 = true) {
		onEvent(EShopEvent.GetProducts)
	}
	Scaffold(
		modifier = modifier
			.fillMaxSize()
			.nestedScroll(scrollBehavior.nestedScrollConnection),
		bottomBar = {
			MyBottomAppBar(
				navController
			)
		},
		topBar = {
			SearchTopAppBar(scrollBehavior, modifier, search)
		},
	) { innerPadding ->
		Column(modifier.padding(innerPadding)) {
			Row(
				modifier
					.fillMaxWidth()
					.padding(5.dp)
			) {
				CategorySelect(modifier.weight(0.8f))
				IconButton(
					{ showBottomSheet = true },
					modifier
						.weight(0.1f)
						.padding(2.dp)
				) {
					Icon(
						imageVector = Icons.AutoMirrored.Filled.Sort,
						contentDescription = "Icon Search"
					)
				}
			}

			if (state.products.isNullOrEmpty()) Text(text = state.message)
			else MyLazyVerticalGrid(state.products, navController)
		}
	}
	if (showBottomSheet) {
		ModalBottomSheet(
			onDismissRequest = { showBottomSheet = false },
			sheetState = sheetState
		) {
			Column(
				Modifier.fillMaxWidth(),
				horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
			) {
				val price = remember {
					mutableStateOf("")
				}
				val rating = remember {
					mutableStateOf("")
				}
				val color = remember {
					mutableStateOf("")
				}
				Text(
					"Filter Item",
					style = MaterialTheme.typography.titleLarge
				)
				TextField(value = price.value,
					onValueChange = { price.value = it },
					label = { Text("Price") })

				TextField(value = rating.value,
					onValueChange = { rating.value = it },
					label = { Text("Rating") })

				TextField(value = color.value,
					onValueChange = { color.value = it },
					label = { Text("Color") })

				Button(
					{
						scope.launch {
							sheetState.hide()
							showBottomSheet = false
						}
							.invokeOnCompletion {
								if (!sheetState.isVisible) {
									showBottomSheet = false
								}
							}
					}
				) {
					Text("Click")
				}
			}
		}
	}
}
