package com.tutor.eshop.screen.app.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ModalSearch(
	sheetState: SheetState,
	scope: CoroutineScope,
	onClose: () -> Unit
) {
	ModalBottomSheet(
		onDismissRequest = onClose,
		sheetState = sheetState
	) {
		Column(
			Modifier.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			val price = remember {
				mutableStateOf("")
			}
			val rating = remember {
				mutableStateOf("")
			}
			val color = remember {
				mutableStateOf("")
			}
			Text(
				"Filter Item",
				style = MaterialTheme.typography.titleLarge
			)
			TextField(value = price.value,
				onValueChange = { price.value = it },
				label = { Text("Price") })

			TextField(value = rating.value,
				onValueChange = { rating.value = it },
				label = { Text("Rating") })

			TextField(value = color.value,
				onValueChange = { color.value = it },
				label = { Text("Color") })

			Button(
				{
					scope.launch {
						sheetState.hide()
						onClose()
					}
						.invokeOnCompletion {
							if (!sheetState.isVisible) {
								onClose()
							}
						}
				}
			) {
				Text("Click")
			}
		}
	}
}