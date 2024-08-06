package com.tutor.eshop.screen.onboarding.OnBoardingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable

fun IndicatorDot(
	pageSize: Int,
	pageCurrent: Int,
	modifier: Modifier = Modifier
) {

	Row(
		modifier = modifier,
		horizontalArrangement = Arrangement.SpaceBetween
	) {

		repeat(pageSize) { page ->
			Box(
				modifier = modifier
					.padding(10.dp)
					.background(
						color = if (page == pageCurrent) MaterialTheme.colorScheme.primary
						else MaterialTheme.colorScheme.primaryContainer,
						shape = CircleShape
					)
					.size(20.dp)
			)
		}
	}
}

@Preview
@Composable
private fun IndicatorDotPrev() {
	IndicatorDot(
		pageSize = 5,
		pageCurrent = 1
	)
}