package com.tutor.eshop.screen.app.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.tutor.eshop.data.model.EStores
import com.tutor.eshop.data.model.exampleItem
import com.tutor.eshop.data.model.exampleItem2
import com.tutor.eshop.screen.app.component.MyBottomAppBar
import com.tutor.eshop.screen.app.component.SearchTopAppBar
import com.tutor.eshop.screen.app.home.MyLazyVerticalGrid
import com.tutor.eshop.screen.app.like.SortFilterLike
import com.tutor.eshop.viewmodel.eshop.EShopEvent
import com.tutor.eshop.viewmodel.eshop.EShopState

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
	val showBottomSheet = remember {
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
		bottomBar = { MyBottomAppBar(navController) },
		topBar = { SearchTopAppBar(scrollBehavior, modifier, search) },
	) { innerPadding ->
		Column(
			modifier
				.padding(innerPadding)
				.fillMaxSize(),
			horizontalAlignment = Alignment.CenterHorizontally,
		) {
			SortFilterLike(showBottomSheet)
			if (state.products.isNullOrEmpty()) Text(text = state.message)
			else MyLazyVerticalGrid(state.products, navController)
		}
	}
	if (showBottomSheet.value) {
		ModalSearch(sheetState, scope) { showBottomSheet.value = false }
	}

}

@Preview(showBackground = true)
@Composable
private fun SearchScreenPrev() {
	val data = EStores()
	data.add(exampleItem2)
	data.add(exampleItem)
	SearchScreen(
		navController = NavHostController(LocalContext.current),
		state = EShopState(products = data),
		onEvent = {}
	)
}