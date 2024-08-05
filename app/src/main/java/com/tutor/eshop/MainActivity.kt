package com.tutor.eshop

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.tutor.eshop.screen.MyNavShopApp
import com.tutor.eshop.ui.theme.EShopTheme
import com.tutor.eshop.viewmodel.EShopViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	private val viewModel: EShopViewModel by viewModels()

	@SuppressLint("StateFlowValueCalledInComposition")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			EShopTheme { MyNavShopApp(viewModel) }
		}
	}

}

