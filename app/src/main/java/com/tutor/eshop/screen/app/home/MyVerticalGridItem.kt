package com.tutor.eshop.screen.app.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.tutor.eshop.data.model.EStores
import com.tutor.eshop.data.model.EStoresItem
import com.tutor.eshop.screen.navigations.Screen
import com.tutor.retrofit_app.eshop.data.model.Rating

@Composable
private fun MyVerticalGridItem(
	item: EStoresItem,
	navController: NavHostController,
	modifier: Modifier = Modifier
) {
	Card(
		modifier
			.fillMaxWidth()
			.padding(horizontal = 5.dp),
	) {
		Column(
			modifier
				.fillMaxWidth()
				.padding(5.dp),
//			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.spacedBy(10.dp)
		) {
			AsyncImage(
				model = item.image,
				contentDescription = item.title,
				contentScale = ContentScale.Inside,
				modifier = modifier
					.size(180.dp)
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
			Column(modifier.padding(horizontal = 5.dp)) {
				Column() {
					Text(
						text = item.title,
						fontWeight = FontWeight.SemiBold,
						maxLines = 2,
						overflow = TextOverflow.Ellipsis,
						style = MaterialTheme.typography.titleSmall
					)
					Text(
						text = item.description,
						maxLines = 1,
						overflow = TextOverflow.Ellipsis,
						style = MaterialTheme.typography.bodySmall

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
						style = MaterialTheme.typography.titleMedium,
						fontWeight = FontWeight.Bold
					)
					IconButton(
						onClick = {
							navController.navigate(Screen.Detail.go(item.id))

						},
						colors = IconButtonDefaults.iconButtonColors(
							containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
						)
					) {
						Icon(
							imageVector = Icons.Default.AddShoppingCart,
							contentDescription = "image"
						)
					}
				}
			}
		}
	}
}

@Composable
fun MyLazyVerticalGrid(
	products: EStores?,
	navController: NavHostController,
	modifier: Modifier = Modifier
) {
	LazyVerticalGrid(
		columns = GridCells.Fixed(2),
		contentPadding = PaddingValues(horizontal = 5.dp),
		verticalArrangement = Arrangement.spacedBy(10.dp)

	) {
		items(products.orEmpty()) { product ->
			MyVerticalGridItem(
				product,
				navController
			)
		}
	}

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
