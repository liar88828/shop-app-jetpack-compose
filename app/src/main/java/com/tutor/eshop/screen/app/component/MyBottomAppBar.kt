package com.tutor.eshop.screen.app.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.tutor.eshop.screen.navigations.Screen
import com.tutor.eshop.screen.onboarding.component.MyNavigationBarItem

data class ListNavbarData(
	val title: String,
	val icon: ImageVector,
	val route: String
)

val listNavbarItem = listOf(
	ListNavbarData(
		"Home",
		Icons.Default.Home,
		Screen.Home.route
	),
	ListNavbarData(
		"Search",
		Icons.Default.Search,
		Screen.Search.route
	),
	ListNavbarData(
		"Like",
		Icons.Default.Favorite,
		Screen.Like.route
	),
	ListNavbarData(
		"Carts",
		Icons.Default.ShoppingBasket,
		Screen.Cart.route
	),
	ListNavbarData(
		"Profile",
		Icons.Default.Person,
		Screen.Profile.route
	),
)

@Composable
fun MyBottomAppBar(navController: NavController) {
	val currentNav = navController.currentDestination?.route
	NavigationBar {
		repeat(listNavbarItem.size) {
			MyNavigationBarItem(
				title = listNavbarItem[it].title,
				icon = listNavbarItem[it].icon,
				route = { navController.navigate(listNavbarItem[it].route) },
				select = currentNav == listNavbarItem[it].route
			)
//			MyNavigationBarItem("Search", Icons.Default.Search)
////		MyNavigationBarItemMiddle()
//
//			MyNavigationBarItem("Message", Icons.AutoMirrored.Filled.Message)
//
//			MyNavigationBarItem("Setting", Icons.Default.Settings)
		}
	}
}

@Composable
private fun RowScope.MyNavigationBarItemMiddle() {
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
}