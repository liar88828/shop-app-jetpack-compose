package com.tutor.eshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.tutor.eshop.screen.navigations.MyNavigation
import com.tutor.eshop.ui.theme.EShopTheme
import com.tutor.eshop.viewmodel.onboarding.OnBoardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	private val onBoardingViewModel by viewModels<OnBoardingViewModel>()
//	private val eShopViewModel by viewModels<EShopViewModel>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		installSplashScreen().setKeepOnScreenCondition {
			onBoardingViewModel.isLoading
		}
		enableEdgeToEdge()
		setContent {
			EShopTheme {
				MyNavigation(
					onBoardingViewModel.startDestination
				)
			}
		}
	}

}


