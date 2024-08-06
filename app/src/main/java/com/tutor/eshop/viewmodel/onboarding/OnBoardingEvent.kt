package com.tutor.eshop.viewmodel.onboarding

sealed interface OnBoardingEvent {
	data object saveAppEntry : OnBoardingEvent

}