package com.tutor.eshop.screen.navigations

import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.tutor.eshop.screen.app.DetailScreen
import com.tutor.eshop.screen.app.HomeScreen
import com.tutor.eshop.screen.onboarding.OnBoardingScreen.OnBoardingScreen
import com.tutor.eshop.viewmodel.eshop.EShopViewModel
import com.tutor.eshop.viewmodel.onboarding.OnBoardingViewModel

@Composable
fun MyNavigation(
	startDestination: String,
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
			navigation(
				route = Screen.Base.route,
				startDestination = Screen.Home.route
			) {

				composable(
					route = Screen.Home.route,
				) {
					val state by eShopViewModel.state.collectAsStateWithLifecycle()
					HomeScreen(
						navController = navController,
						onEvent = eShopViewModel::onEvent,
						state = state
					)
				}
				composable(
					route = Screen.Detail.route,
					arguments = listOf(
						argScr("id", NavType.IntType),
					)
				) { backStackEntry ->
					val state by eShopViewModel.state.collectAsState()
					DetailScreen(
						id = argGetInt(backStackEntry, "id"),
						navController = navController,
						onEvent = eShopViewModel::onEvent,
						state = state
					)
				}
			}
		}
	}
}
