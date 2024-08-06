package com.tutor.eshop.viewmodel.onboarding

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutor.eshop.data.datastore.MyPreferenceDataStore
import com.tutor.eshop.screen.navigations.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel
@Inject constructor(
	private val myPreference: MyPreferenceDataStore
) : ViewModel() {
	var isLoading by mutableStateOf(true)
		private set

	var startDestination by mutableStateOf(Screen.OnBoarding.route)
		private set

	init {
		myPreference.readAppEntry.onEach { loadObBoarding ->
			startDestination = if (loadObBoarding) Screen.OnBoarding.route
			else Screen.Home.route
			delay(300)
			isLoading = false
		}
			.launchIn(viewModelScope)
	}

	fun onEvent(event: OnBoardingEvent) {
		when (event) {
			OnBoardingEvent.saveAppEntry -> {
				saveAppEntry()
			}
		}
	}

	private fun saveAppEntry() {
		viewModelScope.launch {
			myPreference.saveAppEntry()
		}
	}

}

