package com.tutor.eshop.screen.app.carts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.eshop.R
import com.tutor.eshop.data.model.EStoresItem
import com.tutor.eshop.data.model.exampleItem
import com.tutor.eshop.ui.theme.fontInter

@Composable
fun CartProductItemCount(
	item: EStoresItem,
	modifier: Modifier = Modifier
) {
	val count = remember { mutableIntStateOf(0) }
	val isClose = remember {
		mutableStateOf(false)
	}

	fun onClose() {
		isClose.value = false
	}

	fun onOpen() {
		isClose.value = true
	}

	fun onDelete() {
		onClose()

	}
	ElevatedCard(
		modifier = modifier
			.fillMaxWidth()
			.height(120.dp)
			.width(320.dp),
		elevation = CardDefaults.cardElevation(1.dp),
	) {
		Row(
			modifier = modifier
				.fillMaxSize()
				.padding(6.dp),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.spacedBy(10.dp)
		) {
			Box() {

				Box() {
					Image(
						painter = painterResource(id = R.drawable.ic_launcher_foreground),
						contentDescription = "title Product",
						modifier
							.background(
								color = MaterialTheme.colorScheme.primaryContainer,
								shape = MaterialTheme.shapes.medium
							),
					)
				}
				Box() {
					OutlinedIconButton(
						{},
						border = IconButtonDefaults.outlinedIconButtonBorder(false),
						colors = IconButtonDefaults.outlinedIconButtonColors(
							containerColor = MaterialTheme.colorScheme.errorContainer,
							contentColor = MaterialTheme.colorScheme.error,
							disabledContainerColor = MaterialTheme.colorScheme.errorContainer,
							disabledContentColor = MaterialTheme.colorScheme.onErrorContainer,
						),
						shape = MaterialTheme.shapes.medium,
						modifier = modifier
							.size(25.dp)
							.offset(
								x = 5.dp,
								y = 5.dp

							)

					) {
						Icon(
							imageVector = Icons.Default.Favorite,
							contentDescription = "Icon Favorite",
							modifier = modifier.size(15.dp)

						)
					}
				}

			}
			Row(
				modifier
					.fillMaxWidth()
					.padding(4.dp)
			) {
				Column(
					modifier
						.fillMaxHeight()
						.weight(.7f),
					verticalArrangement = Arrangement.SpaceBetween
				) {
					Column(
						verticalArrangement = Arrangement.spacedBy(5.dp)
					) {
						Column {
							Text(
								text = item.category,
								maxLines = 1,
								overflow = TextOverflow.Ellipsis,
								style = MaterialTheme.typography.bodySmall,
								fontWeight = FontWeight.Light,
							)
							//name
							Text(
								text = item.title,
								style = MaterialTheme.typography.titleSmall,
								fontWeight = FontWeight.SemiBold,
								maxLines = 1,
								overflow = TextOverflow.Ellipsis,
							)

							Text(
								text = "$${item.price}",
								style = MaterialTheme.typography.titleSmall,
								fontWeight = FontWeight.Bold,
								fontFamily = fontInter,
							)
						}
					}
					Row(
						verticalAlignment = Alignment.CenterVertically,
						horizontalArrangement = Arrangement.spacedBy(5.dp),
					) {
						ColorChipItem(Color.Red.copy(alpha = 0.5f))
						ColorChipItem(Color.Yellow.copy(alpha = 0.5f))
						ColorChipItem(Color.Blue.copy(alpha = 0.5f))
						SizeChipItem("M")
					}
				}
				Column(
					modifier
						.weight(.3f)
						.fillMaxHeight(),
					verticalArrangement = Arrangement.SpaceBetween,
					horizontalAlignment = Alignment.End

				) {

					OutlinedIconButton(
						{ onOpen() },
						modifier = modifier.size(25.dp),
						shape = MaterialTheme.shapes.small,
						colors = IconButtonDefaults.outlinedIconButtonColors(
							containerColor = MaterialTheme.colorScheme.errorContainer,
							contentColor = MaterialTheme.colorScheme.error,
							disabledContainerColor = MaterialTheme.colorScheme.errorContainer,
							disabledContentColor = MaterialTheme.colorScheme.onErrorContainer,
						),
						border = IconButtonDefaults.outlinedIconButtonBorder(false)
					) {

						Icon(
							imageVector = Icons.Default.Close,
							contentDescription = "Icon Close",
							modifier = modifier

						)
					}
					Row(
						modifier = modifier
							.fillMaxWidth()
							.padding(2.dp),
						verticalAlignment = Alignment.CenterVertically,
						horizontalArrangement = Arrangement.SpaceBetween

					) {
						IconButton(
							{ count.intValue-- },
							modifier = modifier
								.size(25.dp)

						) {
							Icon(
								imageVector = Icons.Default.Remove,
								contentDescription = "Icon close"
							)
						}
						Text(
							text = "${count.value}",
							style = MaterialTheme.typography.titleSmall,
							modifier = modifier
								.background(
									color = MaterialTheme.colorScheme.primaryContainer,
									shape = MaterialTheme.shapes.medium

								)
								.padding(5.dp)
						)
						IconButton(
							{ count.value++ },
							modifier = modifier.size(25.dp)

						) {
							Icon(
								imageVector = Icons.Default.Add,
								contentDescription = "Icon close"
							)
						}
					}
				}
			}
		}
	}
	if (isClose.value) {
		DialogRemoveProduct(
			onDelete = {
				onDelete()
			},
			onClose = { onClose() },
			item = item
		)
	}

}

@Preview
@Composable
private fun CartProductItemCountPrev() {
	CartProductItemCount(
		item = exampleItem
	)
}

@Composable
fun DialogRemoveProduct(
	onDelete: () -> Unit,
	onClose: () -> Unit,
	item: EStoresItem,
) {
	AlertDialog(
		onDismissRequest = onClose,
		confirmButton = {
			Button(onDelete) {
				Text("Yes")
			}
		},
		dismissButton = {
			Button(onClose) {
				Text("No")
			}
		},
		title = {
			Text(
				"Remove Products ${item.title}",
				maxLines = 2,
				textAlign = TextAlign.Center
			)
		},
		icon = {
			Icon(
				imageVector = Icons.Default.Delete,
				contentDescription = "Remove  Icon"
			)
		},
		text = {
			Text(
				"Are you sure to remove this product? ${item.title}",
				maxLines = 2,
				textAlign = TextAlign.Justify
			)
		}

	)
}

@Preview
@Composable
private fun DialogRemoveProductPrev() {
	DialogRemoveProduct(
		item = exampleItem,
		onDelete = {},
		onClose = {}
	)
}

@Composable
fun CartProductItem(
	item: EStoresItem,
	modifier: Modifier = Modifier
) {

	ElevatedCard(
		modifier = modifier
			.fillMaxWidth()
			.height(120.dp)
			.width(320.dp),
		elevation = CardDefaults.cardElevation(1.dp),

		) {
		Row(
			modifier = modifier
				.fillMaxSize()
				.padding(6.dp),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.spacedBy(10.dp)
		) {
			Image(
				painter = painterResource(id = R.drawable.ic_launcher_foreground),
				contentDescription = "title Product",
				modifier
//					.padding(8.dp)
					.background(
						color = MaterialTheme.colorScheme.primaryContainer,
						shape = MaterialTheme.shapes.medium
					),
//				contentScale = ContentScale.Crop
			)
			Column(
				modifier
					.fillMaxHeight()
					.padding(vertical = 2.dp),
//					.padding(start = 4.dp, end = 10.dp)
//					.padding(vertical = 10.dp)

				verticalArrangement = Arrangement.SpaceBetween
			) {
				Column(
					verticalArrangement = Arrangement.spacedBy(5.dp)
				) {
					//brand
					Text(
						text = item.category,
						maxLines = 1,
						overflow = TextOverflow.Ellipsis,
						style = MaterialTheme.typography.bodySmall,
						fontWeight = FontWeight.Light,
					)
					//name
					Text(
						text = item.title,
						style = MaterialTheme.typography.titleSmall,
						fontWeight = FontWeight.SemiBold,
						maxLines = 1,
						overflow = TextOverflow.Ellipsis,
					)

					Text(
						text = "$${item.price}",
						style = MaterialTheme.typography.titleSmall,
						fontWeight = FontWeight.Bold,
						fontFamily = fontInter,
					)
				}
				Row(
					verticalAlignment = Alignment.CenterVertically,
					horizontalArrangement = Arrangement.spacedBy(5.dp),
//					modifier = modifier
//						.border(
//							color = MaterialTheme.colorScheme.primaryContainer,
//							width = 2.dp,
//							shape = MaterialTheme.shapes.medium
//						)
//						.padding(5.dp)
				) {
					ColorChipItem(Color.Red.copy(alpha = 0.5f))
					ColorChipItem(Color.Yellow.copy(alpha = 0.5f))
					ColorChipItem(Color.Blue.copy(alpha = 0.5f))
					SizeChipItem("M")
				}
			}
		}
	}
}

@Composable
fun OldCartProductItem(
	item: EStoresItem,
	modifier: Modifier = Modifier
) {

	ElevatedCard(
		modifier = modifier
			.fillMaxWidth()
			.height(120.dp)
			.width(370.dp),
		elevation = CardDefaults.cardElevation(1.dp),

		) {
		Row(
			modifier = modifier.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically
		) {
			Image(
				painter = painterResource(id = R.drawable.ic_launcher_foreground),
				contentDescription = "title Product",
				modifier
					.padding(8.dp)
					.background(
						color = MaterialTheme.colorScheme.primaryContainer,
						shape = MaterialTheme.shapes.medium
					)
			)
			Column(
				modifier
					.fillMaxHeight()
					.padding(start = 4.dp, end = 10.dp)
					.padding(vertical = 10.dp),
				verticalArrangement = Arrangement.SpaceBetween
			) {
				//brand
				Text(
					text = item.category,
					maxLines = 1,
					overflow = TextOverflow.Ellipsis,
					style = MaterialTheme.typography.bodySmall,

					)
				//name
				Text(
					text = item.title,
					style = MaterialTheme.typography.titleSmall,
					fontWeight = FontWeight.Bold,
					maxLines = 2,
					overflow = TextOverflow.Ellipsis,
				)
				Row(
					modifier
						.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceBetween,
					verticalAlignment = Alignment.CenterVertically
				) {
					// color list and
					Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
						ColorChipItem(Color.Red)
						SizeChipItem("M")
					}
					// price
					Text(
						text = "$${item.price}",
						style = MaterialTheme.typography.titleMedium,
						fontWeight = FontWeight.Bold,
						fontFamily = fontInter,
					)
				}
			}
		}
	}
}

@Composable
private fun ColorChipItem(color: Color) {
	Box(
		modifier = Modifier
			.size(25.dp)
			.border(
				color = MaterialTheme.colorScheme.primaryContainer,
				width = 1.dp,
				shape = MaterialTheme.shapes.medium
			)
			.padding(4.dp)
			.background(
				color = color,
				shape = CircleShape
			)
			.clickable {}
	)
}

@Composable
private fun SizeChipItem(title: String) {
	Box(
		contentAlignment = Alignment.Center,
		modifier = Modifier
			.size(25.dp)
			.border(
				color = MaterialTheme.colorScheme.primaryContainer,
				width = 1.dp,
				shape = MaterialTheme.shapes.medium
			)
//			.padding(4.dp)
			.clickable {}
	) {
		Text(title)
	}
}

@Preview
@Composable
private fun CartProductItemPrev() {
	CartProductItem(
		item = exampleItem
	)

}