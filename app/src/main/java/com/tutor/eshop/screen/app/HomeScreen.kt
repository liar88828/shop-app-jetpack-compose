package com.tutor.eshop.screen.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults.iconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.tutor.eshop.data.model.EStores
import com.tutor.eshop.data.model.EStoresItem
import com.tutor.eshop.screen.navigations.Screen
import com.tutor.eshop.screen.onboarding.component.MyNavigationBarItem
import com.tutor.eshop.viewmodel.eshop.EShopEvent
import com.tutor.eshop.viewmodel.eshop.EShopState
import com.tutor.retrofit_app.eshop.data.model.Rating

@OptIn(ExperimentalMaterial3Api::class)
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

	Scaffold(
		modifier = modifier
			.fillMaxSize()
			.nestedScroll(scrollBehavior.nestedScrollConnection),
		bottomBar = {
			NavigationBar {
				MyNavigationBarItem("Home", Icons.Default.Home)
				MyNavigationBarItem("Search", Icons.Default.Search)

				NavigationBarItem(
					modifier = Modifier,
					colors = NavigationBarItemDefaults.colors(
						unselectedIconColor = MaterialTheme.colorScheme.error,
						unselectedTextColor = MaterialTheme.colorScheme.onSurface,
						selectedIconColor = MaterialTheme.colorScheme.surface,
						selectedTextColor = MaterialTheme.colorScheme.onSurface,
						indicatorColor = MaterialTheme.colorScheme.primary,

						),
					onClick = { /*TODO*/ },
					label = { Text(text = "Public") },
					selected = true,
					icon = {
						Icon(
							imageVector = Icons.Default.Public,
							contentDescription = "Public"
						)
					})
//				FloatingActionButton(onClick = {}) {
//					Icon(
//						imageVector = Icons.Default.Public,
//						contentDescription = "Public"
//					)
//				}
				MyNavigationBarItem("Message", Icons.AutoMirrored.Filled.Message)

				MyNavigationBarItem("Setting", Icons.Default.Settings)
			}
		},
		topBar = {
			TopAppBar(
				scrollBehavior = scrollBehavior,
				title = { Text(text = "E-Shop") },
				actions = {
					IconButton(onClick = { /*TODO*/ }) {
						Icon(
							imageVector = Icons.Default.AddShoppingCart,
							contentDescription = "image"
						)
					}
				},
				colors = TopAppBarDefaults.topAppBarColors(
					containerColor = MaterialTheme.colorScheme.primaryContainer,
					titleContentColor = MaterialTheme.colorScheme.primary,
				),

				)
		},
	) { innerPadding ->
		Box(
			contentAlignment = Alignment.Center,
			modifier = Modifier
				.padding(innerPadding)
				.fillMaxSize()
		) {
			if (state.products.isNullOrEmpty()) Text(text = state.message)
			else MyLazyVerticalGrid(state.products, navController)
		}
	}
}

@Composable
private fun MyLazyVerticalGrid(
	products: EStores?,
	navController: NavHostController,

	modifier: Modifier = Modifier
) {
	LazyVerticalGrid(
		columns = GridCells.Fixed(2),
		contentPadding = PaddingValues(10.dp),
	) {
		items(products.orEmpty()) { product ->
			MyVerticalGridItem(
				product,
				navController
			)
		}
	}

}

@Composable
private fun MyVerticalGridItem(
	item: EStoresItem,
	navController: NavHostController,
	modifier: Modifier = Modifier
) {
	Card(
		modifier
			.fillMaxWidth()
			.padding(5.dp),
	) {
		Column(
			modifier
				.fillMaxWidth()
				.padding(10.dp),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.spacedBy(10.dp)
		) {

			AsyncImage(
				model = item.image,
				contentDescription = item.title,
				contentScale = ContentScale.Inside,
				modifier = modifier
					.size(160.dp)
					.background(
						color = MaterialTheme.colorScheme.background,
						shape = MaterialTheme.shapes.medium
					)
					.padding(10.dp)

			)
//			Image(
//				painter = painterResource(R.drawable.ic_launcher_foreground),
//				contentDescription = item.title,
//				contentScale = ContentScale.Crop,
//				modifier = modifier.size(160.dp)
//			)

			Column() {
				Text(
					text = item.title,
					fontWeight = FontWeight.SemiBold,
					fontSize = 18.sp,
					maxLines = 2,
					overflow = TextOverflow.Ellipsis,
				)
				Text(
					text = item.description, fontSize = 16.sp,
					maxLines = 1,
					overflow = TextOverflow.Ellipsis,
				)
			}
			Row(
				modifier = modifier
					.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {

				Text(
					text = "$${item.price}",
					fontSize = 20.sp,
					fontWeight = FontWeight.Bold
				)
				IconButton(
					onClick = {
						navController.navigate(Screen.Detail.go(item.id))

					},
					colors = iconButtonColors(
						containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
					)
				) {
					Icon(
						imageVector = Icons.Default.AddShoppingCart, contentDescription = "image"
					)
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun MyVerticalGridPrev() {
	MyVerticalGridItem(
		navController = rememberNavController(),
		item = EStoresItem(
			category = "category",
			description = "description",
			id = 1,
			image = "image",
			price = 10000.0,
			rating = Rating(
				count = 1, rate = 1.0
			),
			title = "title"
		)
	)
}

@Preview(showBackground = true)
@Composable
private fun MyLazyVerticalGridPrev() {
	val item1 = EStoresItem(
		category = "Electronics",
		description = "A great electronic product",
		id = 1,
		image = "http://example.com/image1.jpg",
		price = 299.99,
		rating = Rating(rate = 4.5, count = 150),
		title = "Electronic Gadget"
	)

	val item2 = EStoresItem(
		category = "Books",
		description = "A fascinating book",
		id = 2,
		image = "http://example.com/image2.jpg",
		price = 19.99,
		rating = Rating(rate = 4.8, count = 200),
		title = "Interesting Book"
	)

	val stores = EStores()
	stores.add(item1)
	stores.add(item2)
	MyLazyVerticalGrid(
		navController = rememberNavController(),
		products = stores
	)
}

@Preview
@Composable
private fun HomeScreenPrev() {
	HomeScreen(
		navController = rememberNavController(),
		state = EShopState(),
		onEvent = {}
	)
}