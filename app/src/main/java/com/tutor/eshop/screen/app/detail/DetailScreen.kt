package com.tutor.eshop.screen.app.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Paid
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.tutor.eshop.R
import com.tutor.eshop.data.model.EStoresItem
import com.tutor.eshop.viewmodel.eshop.EShopEvent
import com.tutor.eshop.viewmodel.eshop.EShopState
import com.tutor.retrofit_app.eshop.data.model.Rating

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
	id: Int?,
	navController: NavHostController,
	state: EShopState,
	onEvent: (EShopEvent) -> Unit,
	modifier: Modifier = Modifier
) {

	val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
		rememberTopAppBarState()
	)
	val scoped = rememberCoroutineScope()

	LaunchedEffect(key1 = id) {
		if (id != null) {
			onEvent(EShopEvent.GetProduct(id))
		}
	}
	val test = true

	Scaffold(
		modifier = modifier
			.fillMaxSize()
			.nestedScroll(scrollBehavior.nestedScrollConnection),
		bottomBar = { DetailBottomAppBar(modifier) },
		topBar = { DetailTopAppBar(navController, scrollBehavior) },
	) { innerPadding ->
		Box(
			contentAlignment = Alignment.Center,
			modifier = Modifier
				.padding(innerPadding)
				.fillMaxSize()
		) {
			if (test) {
				DetailItem(exampleItemDetailProduct, test = test)
			} else {

				if (state.product == null) Text(text = state.message)
				else {
					if (state.loading) {
						Column(
							horizontalAlignment = Alignment.CenterHorizontally
						) {
							Text("Loading...")
							CircularProgressIndicator()
						}

					} else {
						DetailItem(state.product!!, test = test)
					}
				}
			}
		}
	}
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun DetailTopAppBar(
	navController: NavHostController,
	scrollBehavior: TopAppBarScrollBehavior
) {
	TopAppBar(
		navigationIcon = {
			IconButton(onClick = {
				navController.navigateUp()

			}) {
				Icon(
					imageVector = Icons.Default.ArrowBackIosNew,
					contentDescription = "Back "
				)
			}
		},
		scrollBehavior = scrollBehavior,
		title = { Text(text = "Detail Product") },
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
}

@Composable
private fun DetailBottomAppBar(modifier: Modifier) {
	BottomAppBar(
		containerColor = Color.Transparent,
		contentColor = Color.Transparent,
		windowInsets = WindowInsets(40, 0, 40, 0)
	) {
		Row(
			modifier = modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.SpaceBetween,
		) {
			FloatingActionButton(onClick = {}) {
				Icon(
					imageVector = Icons.Default.Favorite,
					contentDescription = "Icons Favorite"
				)
			}
			ExtendedFloatingActionButton(
				onClick = {}
			) {
				Row(
					horizontalArrangement = Arrangement.spacedBy(8.dp),
					verticalAlignment = Alignment.CenterVertically

				) {

					Icon(
						imageVector = Icons.Default.Paid,
						contentDescription = "Paid"
					)

					Text(text = "Buy Now")
				}
			}
			ExtendedFloatingActionButton(
				onClick = {}
			) {
				Row(
					horizontalArrangement = Arrangement.spacedBy(8.dp),
					verticalAlignment = Alignment.CenterVertically

				) {

					Icon(
						imageVector = Icons.Default.AddShoppingCart,
						contentDescription = "AddShoppingCart"
					)

					Text(text = "Add  Trolley")
				}
			}
		}

	}
}

@Composable
private fun DetailItem(
	item: EStoresItem,
	test: Boolean = false,
	modifier: Modifier = Modifier
) {
	LazyColumn(
		contentPadding = PaddingValues(10.dp),
		verticalArrangement = Arrangement.spacedBy(10.dp),
		modifier = modifier.fillMaxHeight()
	) {
		item() {
			DetailProductItem(test, item)
		}
		item {
			PersonCommentScreen()

		}
	}
}

@Composable
private fun DetailProductItem(
	test: Boolean,
	item: EStoresItem,
	modifier: Modifier = Modifier,
) {
	Card(
		modifier.fillMaxWidth(),
	) {
		Column(
			modifier
				.fillMaxWidth()
				.padding(10.dp),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.spacedBy(10.dp)
		) {
			if (test) {
				Image(
					painter = painterResource(R.drawable.ic_launcher_foreground),
					contentDescription = item.title,
					contentScale = ContentScale.Inside,
					modifier = modifier
						.size(400.dp)
						.background(
							color = MaterialTheme.colorScheme.background,
							shape = MaterialTheme.shapes.medium
						)
						.padding(10.dp)

				)
			} else {
				AsyncImage(
					model = item.image,
					contentDescription = item.title,
					contentScale = ContentScale.Inside,
					modifier = modifier
						.size(400.dp)
						.background(
							color = MaterialTheme.colorScheme.background,
							shape = MaterialTheme.shapes.medium
						)
						.padding(10.dp)
				)

			}

			Column(
				modifier = modifier.fillMaxWidth(),
			) {
				Text(
					text = item.title,
					overflow = TextOverflow.Ellipsis,
					maxLines = 2,
					style = MaterialTheme.typography.titleLarge,
				)
				Text(
					text = "$${item.price}",
					style = MaterialTheme.typography.bodyLarge,
					fontWeight = FontWeight.Bold
				)
			}

			Column(modifier = modifier.fillMaxWidth()) {
				Text(
					text = "Category ",
					style = MaterialTheme.typography.titleMedium,
				)
				Text(
					text = item.category,
					style = MaterialTheme.typography.bodyMedium,
				)
			}
			Column(
				modifier = modifier
					.fillMaxWidth()
//							.verticalScroll(rememberScrollState())

			) {
				Text(
					text = "Description",
					style = MaterialTheme.typography.titleMedium,

					)
				Text(
					text = item.description,
					textAlign = TextAlign.Justify,
					style = MaterialTheme.typography.bodySmall,

					)
			}
		}
	}
}

//IconButton(
//onClick = { /*TODO*/ },
//colors = iconButtonColors(
//containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
//)
//) {
//	Icon(
//		imageVector = Icons.Default.AddShoppingCart, contentDescription = "image"
//	)
//}

@Preview
@Composable
private fun DetailScreenPrev() {
	DetailScreen(
		id = 1234,
		onEvent = {},
		navController = rememberNavController(),
		state = remember { mutableStateOf(EShopState()) }.value

	)

}

@Preview
@Composable
private fun DetailItemPrev() {

	DetailItem(
		item = exampleItemDetailProduct
	)
}

val exampleItemDetailProduct = EStoresItem(
	category = "category",
	description = "description Ahoy, yellow fever! Cum detrius tolerare, omnes mineralises prensionem domesticus, primus urbses. leo platonem et consul elaboraret tellus lectus idque adversarium veri aperiri ornatus nascetur nulla novum lectus sapien fugit indoctum vocibus suavitate comprehensam ornare perpetua instructior pertinacia sapientem utroque inceptos voluptatibus fugit necessitatibus vitae arcu dico accusata persius dico praesent recteque",
	id = 1,
	image = "image",
	price = 10000.0,
	rating = Rating(
		count = 1, rate = 1.0
	),
	title = "Alicia Ge Isaac Sari"

)