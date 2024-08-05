package com.tutor.eshop.screen

import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tutor.eshop.viewmodel.EShopViewModel

@Composable
fun MyNavShopApp(
	viewModel: EShopViewModel
) {
	ModalNavigationDrawer(
		drawerContent = {
			ModalDrawerSheet {
				Text("Hello Drawer")
			}
		}
	) {
		val navController = rememberNavController()
		NavHost(
			navController = navController,
			startDestination = EStoreRoute.Home.route
		) {
			composable(
				route = EStoreRoute.Home.route,
			) {
				val state by viewModel.state.collectAsState()
				HomeScreen(
					navController = navController,
					onEvent = viewModel::onEvent,
					state = state
				)
			}
			composable(
				route = EStoreRoute.Detail.route,
				arguments = listOf(navArgument("id") { type = NavType.IntType })
			) { backStackEntry ->
				val state by viewModel.state.collectAsState()

				DetailScreen(
					id = backStackEntry.arguments?.getInt("id") ?: 0,
					navController = navController,
					onEvent = viewModel::onEvent,
					state = state
				)
			}
		}
	}
}