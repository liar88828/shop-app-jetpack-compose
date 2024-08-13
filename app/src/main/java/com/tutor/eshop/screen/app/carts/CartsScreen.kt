package com.tutor.eshop.screen.app.carts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
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
import com.tutor.eshop.screen.app.component.CartsTopAppBar
import com.tutor.eshop.screen.app.component.MyBottomAppBar
import com.tutor.eshop.screen.app.transaction.CheckOutScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartsScreen(
	navController: NavHostController,
//	state: EShopState,
//	onEvent: (EShopEvent) -> Unit,
	modifier: Modifier = Modifier,
) {
	val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
		rememberTopAppBarState()
	)

	val scoped = rememberCoroutineScope()
//	LaunchedEffect(key1 = true) {
//		onEvent(EShopEvent.GetProducts)
//	}
	var search = remember {
		mutableStateOf("")
	}
	val sheetState = rememberModalBottomSheetState()
	val scope = rememberCoroutineScope()
	var showBottomSheet by remember { mutableStateOf(false) }
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
			CartsTopAppBar(scrollBehavior, modifier, search)
		},
	) { innerPadding ->
		Column(
			modifier
				.padding(innerPadding)
				.fillMaxHeight()
				.padding(10.dp)
		) {
			CheckoutScreen({ showBottomSheet = true })
		}

		if (showBottomSheet) {
			ModalBottomSheet(
				onDismissRequest = { showBottomSheet = false },
				sheetState = sheetState,
			) {
				CheckOutScreen(
					onClick = {
						scope.launch { sheetState.hide() }
							.invokeOnCompletion {
								if (!sheetState.isVisible) {
									showBottomSheet = false
								}
							}
					}
				)
			}
		}
	}

}

@Preview
@Composable
private fun CartsScreenPrev() {
	CartsScreen(
		navController = rememberNavController(),
//		onEvent = {},
//		state = EShopState()

	)

}