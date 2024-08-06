package com.tutor.eshop.screen.onboarding.OnBoardingScreen

import com.tutor.eshop.R

data class OnBoardingData(
	val title: String,
	val description: String,
	val image: Int
)

val onBoardingList = listOf(
	OnBoardingData(
		title = "Louis Khan",
		description = "Travel and you will be felt daily. Dead, black ales oppressively lead a undead, weird tuna.",
		image = R.drawable.obs_1
	),
	OnBoardingData(
		title = "Ram Mahto",
		description = "The ascension of absorbing sinners is honorable. posse populo mediocrem legimus hendrerit lacus elit aeque orci sollicitudin",
		image = R.drawable.obs_2
	),
	OnBoardingData(
		title = "Marie Kumari",
		description = "Die and you will be emerged harmoniously. Black malarias lead to the treasure.Fishs are the gibbets of the wet fight.Rob me woodchuck, ye proud parrot!",
		image = R.drawable.obs_3
	),
)