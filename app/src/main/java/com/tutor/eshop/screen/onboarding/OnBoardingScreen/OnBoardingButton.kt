package com.tutor.eshop.screen.onboarding.OnBoardingScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NextBackButton(
	pageSize: Int,
	pageCurrent: Int,
	onNext: () -> Unit,
	onBack: () -> Unit,
	onStart: () -> Unit,
	modifier: Modifier = Modifier
) {
	var current = pageCurrent == pageSize-1
	Row(
		verticalAlignment = Alignment.CenterVertically,
	) {
		if (pageCurrent != 0) {
			TextButton(onClick = { onBack() }) { Text(text = "Back") }
		}
		Spacer(modifier = modifier.size(8.dp))
		Button(
			onClick = {
				if (current) onStart()
				else onNext()
			},

			colors = ButtonDefaults.buttonColors(
//				containerColor = MaterialTheme.colorScheme.primary,
//				contentColor = MaterialTheme.colorScheme.onPrimary
			)
		) {
			Text(
				text = if (current) "Get Started" else "Next"
			)

		}

	}
}

@Preview
@Composable
private fun NextBackButtonPrev() {
	NextBackButton(
		pageSize = 23,
		pageCurrent = 1,
		onNext = {},
		onBack = {},
		onStart = {}
	)
}