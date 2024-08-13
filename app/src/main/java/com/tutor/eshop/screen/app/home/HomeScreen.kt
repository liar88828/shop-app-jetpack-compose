package com.tutor.eshop.screen.app.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tutor.eshop.screen.app.cart.ListRowProductScreen
import com.tutor.eshop.screen.app.component.HomeTopAppBar
import com.tutor.eshop.screen.app.component.MyBottomAppBar
import com.tutor.eshop.viewmodel.eshop.EShopEvent
import com.tutor.eshop.viewmodel.eshop.EShopState

@OptIn(
	ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class
)
@Composable
fun HomeScreen(
	navController: NavHostController,
	state: EShopState,
	onEvent: (EShopEvent) -> Unit,
	modifier: Modifier = Modifier,
//	viewModel: EShopViewModel = hiltViewModel()
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
			verticalArrangement = Arrangement.spacedBy(10.dp),
		) {

			LazyColumn(modifier.fillMaxSize()) {
				item {
					CategorySelect()
					CarouselPromo()
					ListRowProductScreen(
						title = "Promotion",
						textButton = "See All",
						buttonAction = { /*TODO*/ },
						list = state.products ?: listOf()
					)
				}
				item() {
					ListRowProductScreen(
						title = "New Products",
						textButton = "See All",
						buttonAction = { /*TODO*/ },
						list = state.products ?: listOf()
					)
				}
				item() {
					ListRowProductScreen(
						title = "Discount",
						textButton = "See All",
						buttonAction = { /*TODO*/ },
						list = state.products ?: listOf()
					)
				}

			}

		}
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPrev() {
	HomeScreen(navController = rememberNavController(), state = EShopState(), onEvent = {})
}
