package com.tutor.eshop.screen.app.carts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tutor.eshop.data.model.EStores
import com.tutor.eshop.data.model.exampleItem
import com.tutor.eshop.data.model.exampleItem2
import com.tutor.eshop.screen.app.component.CartsTopAppBar
import com.tutor.eshop.screen.app.component.MyBottomAppBar
import com.tutor.eshop.screen.app.transaction.CheckOutScreen
import com.tutor.eshop.screen.navigations.Screen
import com.tutor.eshop.viewmodel.eshop.EShopEvent
import com.tutor.eshop.viewmodel.eshop.EShopState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartsScreen(
	navController: NavHostController,
	state: EShopState,
	onEvent: (EShopEvent) -> Unit,
	modifier: Modifier = Modifier,
) {
	val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
		rememberTopAppBarState()
	)

	val scoped = rememberCoroutineScope()
	LaunchedEffect(key1 = true) {
		onEvent(EShopEvent.GetProducts)
	}
	var search = remember {
		mutableStateOf("")
	}
	val sheetState = rememberModalBottomSheetState(
		skipPartiallyExpanded = true
	)
	val scope = rememberCoroutineScope()
	var showBottomSheet by remember { mutableStateOf(false) }

	val snackbarHostState = remember { SnackbarHostState() }
	fun onOpen() {
		showBottomSheet = true
	}

	fun onClose() {
		scope.launch { sheetState.hide() }
			.invokeOnCompletion {
				if (!sheetState.isVisible) {
					showBottomSheet = false
				}
			}
	}

	fun onResponse(): Boolean {
		return false
	}

	fun onCheckout(): Boolean {
		val result = onResponse()
		return if (result) {
			navController.navigate(Screen.Home.route)
			true
		} else {
			scope.launch {
				snackbarHostState.showSnackbar("Error Bos")
			}

			onClose()
			false
		}
	}


	Scaffold(
		snackbarHost = {
			SnackbarHost(hostState = snackbarHostState)
		},
		modifier = modifier
			.fillMaxSize()
			.nestedScroll(scrollBehavior.nestedScrollConnection),
		bottomBar = {
			MyBottomAppBar(navController)
		},
		topBar = {
			CartsTopAppBar(scrollBehavior, modifier, search)
		},
		floatingActionButton = {
			FloatingActionButton(onClick = { onOpen() }) {
				Icon(
					imageVector = Icons.Default.Sell,
					contentDescription = "Sell Icon"
				)
			}
		}
	) { innerPadding ->
		Column(
			modifier
				.padding(innerPadding)
				.fillMaxHeight()
				.padding(10.dp)
		) {
			CheckoutScreen(
				products = state.products ?: listOf(),
				{ showBottomSheet = true }
			)
		}

		if (showBottomSheet) {
			ModalBottomSheet(
				onDismissRequest = { showBottomSheet = false },
				sheetState = sheetState,
			) {
				CheckOutScreen(
					onCheckout = { onCheckout() },
					onClose = { onClose() }
				)
			}
		}
	}

}

@Preview
@Composable
private fun CartsScreenPrev() {
	val data = EStores()
	data.add(exampleItem)
	data.add(exampleItem2)
	CartsScreen(
		navController = rememberNavController(),
		state = EShopState(
			products = data
		),
		onEvent = {},
//		onEvent = {},
//		state = EShopState()

	)

}