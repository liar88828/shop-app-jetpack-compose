package com.tutor.eshop.screen.app.like

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavHostController
import com.tutor.eshop.screen.app.component.HomeTopAppBar
import com.tutor.eshop.screen.app.component.MyBottomAppBar
import com.tutor.eshop.screen.app.home.MyLazyVerticalGrid
import com.tutor.eshop.screen.app.search.ModalSearch
import com.tutor.eshop.viewmodel.eshop.EShopEvent
import com.tutor.eshop.viewmodel.eshop.EShopState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LikeScreen(
	navController: NavHostController,
	state: EShopState,
	onEvent: (EShopEvent) -> Unit,
	modifier: Modifier = Modifier,
) {
	val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

//	LaunchedEffect(key1 = true) {
//		onEvent(EShopEvent.GetProducts)
//	}
	val search = remember {
		mutableStateOf("")
	}
	val showBottomSheet = remember {
		mutableStateOf(false)
	}
	val sheetState = rememberModalBottomSheetState()
	val scope = rememberCoroutineScope()

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
			HomeTopAppBar(scrollBehavior, modifier, search)
		},
	) { innerPadding ->
		Column(
			modifier = Modifier
				.padding(innerPadding)
				.fillMaxSize(),
//				.verticalScroll(
//					rememberScrollState(),
//				)
//
			horizontalAlignment = Alignment.CenterHorizontally,
		) {
			SortFilterLike(showBottomSheet)
			if (showBottomSheet.value) {
				ModalSearch(sheetState, scope) { showBottomSheet.value = false }
			}
			if (state.products.isNullOrEmpty()) Text(text = state.message)
			else MyLazyVerticalGrid(state.products, navController)
		}
	}
}