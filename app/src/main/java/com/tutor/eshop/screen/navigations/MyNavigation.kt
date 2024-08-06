package com.tutor.eshop.screen.navigations

import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tutor.eshop.screen.app.DetailScreen
import com.tutor.eshop.screen.app.HomeScreen
import com.tutor.eshop.screen.onboarding.OnBoardingScreen.OnBoardingScreen
import com.tutor.eshop.viewmodel.eshop.EShopViewModel
import com.tutor.eshop.viewmodel.onboarding.OnBoardingViewModel

@Composable
fun MyNavigation(
	startDestination:String,
	eShopViewModel: EShopViewModel = hiltViewModel(),
	onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
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
			startDestination = startDestination//Screen.Home.route
		) {
			composable(
				route = Screen.OnBoarding.route
			) {
				OnBoardingScreen(
					onEvent = onBoardingViewModel::onEvent
				)
			}
			composable(
				route = Screen.Home.route,
			) {
				HomeScreen(
					navController = navController,
					onEvent = eShopViewModel::onEvent,
					state = eShopViewModel.state.collectAsState().value
				)
			}
			composable(
				route = Screen.Detail.route,
				arguments = listOf(navArgument("id") { type = NavType.IntType })
			) { backStackEntry ->
				DetailScreen(
					id = backStackEntry.arguments?.getInt("id") ?: 0,
					navController = navController,
					onEvent = eShopViewModel::onEvent,
					state = eShopViewModel.state.collectAsState().value
				)
			}
		}
	}
}