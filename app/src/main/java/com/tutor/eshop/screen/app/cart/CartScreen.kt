package com.tutor.eshop.screen.app.cart

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tutor.eshop.R
import com.tutor.eshop.data.model.EStoresItem
import com.tutor.eshop.data.model.exampleItem
import com.tutor.eshop.ui.theme.fontInter

@Composable
fun CartScreen(modifier: Modifier = Modifier) {
	ElevatedCard(
		modifier = modifier.fillMaxWidth(),
		elevation = CardDefaults.cardElevation(4.dp),
		colors = CardDefaults.cardColors(
//			containerColor = MaterialTheme.colorScheme.onPrimary
		)
	) {
		Column(
			modifier = modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(15.dp)
		) {

			Row(
				modifier = modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Text(
					text = "Shop Cart",
					fontFamily = fontInter,
					style = MaterialTheme.typography.titleLarge,
					fontWeight = FontWeight.Bold,
				)

				OutlinedIconButton(
					onClick = {},

					shape = MaterialTheme.shapes.medium
				) {
					Icon(imageVector = Icons.Default.Close, contentDescription = "Icon close")
				}
			}

			LazyColumn(
				verticalArrangement = Arrangement.spacedBy(2.dp)
			) {
				items(4) {
					CartProductItem(
						item = exampleItem
					)
				}
			}

			Button(
				onClick = {},
				shape = MaterialTheme.shapes.medium,
				modifier = modifier.fillMaxWidth()
			) {
				Text(
					text = "Checkout : ( 10 )",
					fontFamily = fontInter,
					style = MaterialTheme.typography.titleSmall,
					fontWeight = FontWeight.Bold
				)

			}
		}
	}
}

@Composable
fun CartProductItem(
	item: EStoresItem, modifier: Modifier = Modifier
) {

	ElevatedCard(
		modifier = modifier.padding(3.dp),
		elevation = CardDefaults.cardElevation(1.dp),

		) {
		Row(
			modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
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
			Column(modifier.padding(start = 4.dp, end = 20.dp)) {
				//brand
				Text(
					text = item.category, fontFamily = fontInter
				)
				//name
				Text(
					text = item.title,
					style = MaterialTheme.typography.titleMedium,
					fontWeight = FontWeight.Bold,
					fontFamily = fontInter
				)
				Row(
					modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceBetween,
					verticalAlignment = Alignment.CenterVertically
				) {
					// color list and
					Row(
						horizontalArrangement = Arrangement.spacedBy(2.dp)
					) {
						InputChip(
							selected = false,
							onClick = {},
							label = {
								Box(
									modifier = modifier
										.background(
											color = MaterialTheme.colorScheme.error,
											shape = CircleShape
										)
										.size(15.dp)
								)
							},
						)
//						Size
						InputChip(

							onClick = {},
							label = {
								Text(
									text = "M",
									style = MaterialTheme.typography.titleMedium,
									fontSize = 15.sp
								)
							},
							selected = false,
						)
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
fun MarketProfileScreen(modifier: Modifier = Modifier) {
	Card {
		Row {

			Column(
				modifier.padding(15.dp),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.spacedBy(8.dp)
			) {
				Image(
					modifier = modifier
						.border(
							width = 1.dp,
							color = MaterialTheme.colorScheme.primary,
							shape = CircleShape
						)
						.background(
							color = MaterialTheme.colorScheme.primaryContainer, shape = CircleShape
						)
						.clip(shape = CircleShape),
					contentScale = ContentScale.Crop,
					painter = painterResource(R.drawable.ic_launcher_background),
					contentDescription = "title Market",
				)
				Text(
					text = "Market Profile",
					style = MaterialTheme.typography.titleLarge,
				)
				Row(

					horizontalArrangement = Arrangement.Center
				) {
					Icon(
						imageVector = Icons.Default.CheckCircle,
						contentDescription = "Icon New Releases",
						tint = MaterialTheme.colorScheme.primary
					)
					Text(
						text = "Official Store",
						style = MaterialTheme.typography.titleMedium,
						fontWeight = FontWeight.Normal

					)
				}
				Text(
					text = "Since February 10, 2020",
					style = MaterialTheme.typography.bodyMedium,
					fontWeight = FontWeight.Light
				)

			}
			Column(
				modifier.padding(15.dp),
				horizontalAlignment = Alignment.Start,
//				verticalArrangement = Arrangement.spacedBy(10.dp)
			) {

				MarketProfileStatic(size = "50 +", title = "Total Products")
				HorizontalDivider(
					modifier = modifier
						.padding(vertical = 10.dp)
						.size(width = 120.dp, height = 1.dp)
				)

				MarketProfileStatic(size = "4.5", title = "App Ratings")
				HorizontalDivider(
					modifier = modifier
						.padding(vertical = 10.dp)
						.size(width = 120.dp, height = 1.dp)
				)

				MarketProfileStatic(size = "50 +", title = "Cust. Reviews")
				HorizontalDivider(
					modifier = modifier
						.padding(vertical = 10.dp)
						.size(width = 120.dp, height = 1.dp)
				)

			}
		}
	}
}

@Composable
private fun MarketProfileStatic(modifier: Modifier = Modifier, size: String, title: String) {
	Column {
		Text(
			text = size,
			style = MaterialTheme.typography.headlineLarge,
			fontWeight = FontWeight.Bold
		)

		Text(
			text = title,
			style = MaterialTheme.typography.bodyMedium,
			fontWeight = FontWeight.Normal,
			fontFamily = fontInter
		)
	}

}

@Composable
fun VerticalProduct(modifier: Modifier = Modifier) {
	Card(
		elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
		modifier = modifier.fillMaxWidth(),
		colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary)
	) {
		Box(modifier.padding(5.dp)) {
			Image(
				painter = painterResource(id = R.drawable.ic_launcher_foreground),
				contentDescription = "title Product",
//				contentScale = ContentScale.Crop,
				modifier = modifier
					.size(160.dp)
					.background(
						color = MaterialTheme.colorScheme.primaryContainer,
						shape = MaterialTheme.shapes.medium
					)
			)

			Box(
				modifier = modifier
					.padding(5.dp)
					.align(Alignment.TopStart)
			) {

				Badge() {
					Text(
						modifier = modifier.padding(2.dp), text = "NEW", fontSize = 10.sp
					)
				}
			}

			Box(
				modifier = modifier
					.padding(5.dp)
					.align(Alignment.TopEnd), contentAlignment = Alignment.Center
			) {
				Badge {
					Row(
						modifier = modifier.padding(2.dp),
						horizontalArrangement = Arrangement.Center,
						verticalAlignment = Alignment.CenterVertically
					) {
						Icon(
							imageVector = Icons.Default.Star,
							contentDescription = "Icon New Releases",
							modifier = modifier.size(12.dp),
							tint = MaterialTheme.colorScheme.onPrimary
						)
						Text(text = "4.4", fontSize = 10.sp)
					}
				}
			}
			Box(
				modifier = modifier
					.align(Alignment.BottomEnd)
					.offset(
						x = (-10).dp, y = 20.dp
					)

			) {
				OutlinedIconButton(
					border = BorderStroke(
						width = 2.dp, color = MaterialTheme.colorScheme.onPrimary
					),
					onClick = {},
					colors = IconButtonDefaults.outlinedIconButtonColors(
						containerColor = MaterialTheme.colorScheme.primaryContainer,
						contentColor = MaterialTheme.colorScheme.primary,
					),
				) {
					Icon(
						imageVector = Icons.Default.Add, contentDescription = "Icon Add"
					)
				}
			}

		}
		Column(modifier = modifier.padding(10.dp)) {

			Text(
				text = "brand",
				style = MaterialTheme.typography.bodySmall,
				fontWeight = FontWeight.Thin,
				fontFamily = fontInter,
			)
			Text(
				text = "title Product",
				style = MaterialTheme.typography.titleMedium,
				fontWeight = FontWeight.SemiBold,
				fontFamily = fontInter
			)
			Text(
				text = "$1342.23",
				style = MaterialTheme.typography.bodyMedium,
				fontWeight = FontWeight.Bold,
				fontFamily = fontInter
			)
			Row(
				horizontalArrangement = Arrangement.spacedBy(5.dp)
			) {
				InputChip(shape = CircleShape, selected = false, onClick = {}, label = {
					Box(
						modifier = modifier
							.background(
								color = Color.Red, shape = CircleShape
							)
							.size(15.dp)
							.padding(2.dp)
					)
				})
				InputChip(shape = CircleShape, selected = false, onClick = {}, label = {
					Text(text = "M")
				})
			}
		}
	}

}

@Composable
private fun ListRowProduct(modifier: Modifier = Modifier) {
	Card(
		modifier = modifier.fillMaxWidth()
	) {
		Row(
			modifier = modifier
				.fillMaxWidth()
				.padding(horizontal = 10.dp),
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(
				text = "New Products", style = MaterialTheme.typography.titleLarge
			)
			TextButton({}) {
				Text(text = "See All")
			}
		}
		LazyRow(
			modifier = modifier.padding(10.dp), horizontalArrangement = Arrangement.spacedBy(15.dp)
		) {
			items(6) {
				VerticalProduct()
			}
		}
	}
}

@Composable
fun PersonComment(modifier: Modifier = Modifier) {
	Card(
	) {
		Column(
			modifier = modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
		) {

			Row(
				modifier = modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
			) {
				Row {
					Image(
						painter = painterResource(id = R.drawable.ic_launcher_foreground),
						contentDescription = "title Product",
						modifier
							.clip(CircleShape)
							.size(50.dp)
							.background(
								color = MaterialTheme.colorScheme.primaryContainer,
							)
					)
					Column(
						modifier = modifier.padding(horizontal = 10.dp),
					) {
						Text(
							text = "Rajendra Rodriguez", style = MaterialTheme.typography.titleLarge
						)
						Spacer(modifier.height(5.dp))
						Text(
							text = "2 days ago",
							style = MaterialTheme.typography.bodySmall,
							fontWeight = FontWeight.Light
						)
					}
				}
				Row {
					OutlinedIconButton(
						{},
						modifier = modifier.padding(2.dp),
						border = BorderStroke(
							width = 1.dp,
							color = MaterialTheme.colorScheme.primary,
						),
						colors = IconButtonDefaults.outlinedIconButtonColors(
							containerColor = MaterialTheme.colorScheme.primaryContainer,
							contentColor = MaterialTheme.colorScheme.primary,
						),
					) {
						Icon(
							imageVector = Icons.AutoMirrored.Filled.Message,
							contentDescription = "Icon Message",
							tint = MaterialTheme.colorScheme.primary
						)
					}
					OutlinedIconButton(
						{},
						modifier = modifier.padding(2.dp),
						border = BorderStroke(
							width = 1.dp,
							color = MaterialTheme.colorScheme.primary,
						),
						colors = IconButtonDefaults.outlinedIconButtonColors(
							containerColor = MaterialTheme.colorScheme.primaryContainer,
							contentColor = MaterialTheme.colorScheme.primary,
						),
					) {
						Icon(
							imageVector = Icons.Default.MoreHoriz,
							contentDescription = "Icon More",
							tint = MaterialTheme.colorScheme.primary

						)
					}
				}
			}

			Row(
				modifier = modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.spacedBy(10.dp),
				verticalAlignment = Alignment.CenterVertically
			) {
				Badge(
				) {
					Icon(
						imageVector = Icons.Default.Star,
						contentDescription = "Icon Star",
						modifier = modifier.size(12.dp)
					)
					Text(text = "4.5")

				}

				Text(
					text = "4 Photos",
					style = MaterialTheme.typography.bodySmall,
					fontWeight = FontWeight.Light
				)

				Text(
					text = "5 Discussion",
					style = MaterialTheme.typography.bodySmall,
					fontWeight = FontWeight.Light
				)
			}

			Text(text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren,")

			LazyRow(
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.spacedBy(8.dp)
			) {
				items(3) {
					Image(
						painter = painterResource(id = R.drawable.ic_launcher_foreground),
						contentDescription = "title Product",
						modifier
							.clip(MaterialTheme.shapes.medium)
							.size(80.dp)
							.background(color = MaterialTheme.colorScheme.primaryContainer)

					)
				}
				item() {
					IconButton({}) {
						Icon(
							imageVector = Icons.Default.Add,
							contentDescription = "Icon Add",
							tint = MaterialTheme.colorScheme.primary
						)
					}
				}
			}
		}
	}
}

@Composable
fun PersonDelivery(modifier: Modifier = Modifier) {
	Card(
		modifier.fillMaxWidth()
	) {
		Column(
			modifier = modifier
				.fillMaxWidth()
				.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)
		) {

			Row(
				modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Row(
					horizontalArrangement = Arrangement.spacedBy(4.dp)
				) {
					VerticalDivider(
						modifier.size(height = 24.dp, width = 1.dp),
						thickness = 2.dp,
						color = MaterialTheme.colorScheme.primary
					)
					Text(
						text = "Delivery",
						style = MaterialTheme.typography.titleLarge,
						fontWeight = FontWeight.Bold,
						fontFamily = fontInter
					)
				}
				OutlinedIconButton(
					modifier = modifier.size(30.dp),
					onClick = {},
					shape = MaterialTheme.shapes.medium,
					border = BorderStroke(
						width = 1.dp, color = MaterialTheme.colorScheme.primary
					),
					colors = IconButtonDefaults.outlinedIconButtonColors(
						containerColor = MaterialTheme.colorScheme.primaryContainer,
					)
				) {
					Icon(imageVector = Icons.Default.MoreHoriz, contentDescription = "Icon More")
				}
			}

			Card(
				colors = CardDefaults.cardColors(
					containerColor = MaterialTheme.colorScheme.primaryContainer
				)
			) {
				Column(modifier = modifier.padding(5.dp)) {
					Row(
						modifier = modifier

							.padding(5.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)
					) {
						Row(verticalAlignment = Alignment.CenterVertically) {
							Icon(
								imageVector = Icons.Default.Person,
								contentDescription = "Icon Person"
							)
							Text(
								text = "Rajendra Rodriguez", fontWeight = FontWeight.SemiBold
							)
						}
						VerticalDivider(modifier.size(height = 24.dp, width = 1.dp))
						Row(verticalAlignment = Alignment.CenterVertically) {
							Icon(
								imageVector = Icons.Default.Phone,
								contentDescription = "Icon Person"
							)
							Text(
								text = "+628123456789", fontWeight = FontWeight.SemiBold
							)
						}
					}
					Text(
						text = "deserunt urna tincidunt falli primis fusce fames torquent eu contentiones cursus delectus partiendo nascetur dicunt an ridens comprehensam oratio hinc intellegat te detracto ubique iriure eu menandri tacimates veri ligula nulla populo noster possim rutrum autem primis noluisse ultrices reque",
						fontWeight = FontWeight.Light,
						fontFamily = fontInter,
						style = MaterialTheme.typography.bodySmall,
						modifier = modifier.padding(horizontal = 10.dp)
					)
				}
			}

			Row(
				modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Row(
					verticalAlignment = Alignment.CenterVertically,

					) {
					Icon(
						imageVector = Icons.Default.LocationOn,
						contentDescription = "Icon Location",
						modifier = modifier.size(30.dp),
						tint = MaterialTheme.colorScheme.primary
					)
					Column {
						Text(
							text = "Google Maps On", color = MaterialTheme.colorScheme.primary
						)
						Text(
							text = "Jakarta, Indonesia", color = MaterialTheme.colorScheme.primary

						)
					}
				}
				Button(
					{},
					shape = MaterialTheme.shapes.medium,
				) {
					Text(text = "Change")
				}
			}
		}
	}
}

@Composable
fun CheckOutScreen(modifier: Modifier = Modifier) {
	Card(modifier.fillMaxWidth()) {
		Column(
			modifier
				.fillMaxWidth()
				.padding(14.dp),
			verticalArrangement = Arrangement.spacedBy(8.dp)
		) {
			TitleCard(
				title = "Summary",
				component = {
					OutlinedIconButton(
						modifier = modifier.size(30.dp),
						onClick = {},
						shape = MaterialTheme.shapes.medium,
						border = BorderStroke(
							width = 1.dp, color = MaterialTheme.colorScheme.primary
						),
						colors = IconButtonDefaults.outlinedIconButtonColors(
							containerColor = MaterialTheme.colorScheme.primaryContainer,
						)
					) {
						Icon(
							imageVector = Icons.Default.MoreHoriz,
							contentDescription = "Icon More"
						)
					}
				})

			CheckoutItem(title = "Detail Total", content = {
				RowText(title = "Price Total", price = 200)
				RowText(title = "Product Protection", price = 2)
				RowText(title = "Delivery Fee", price = 20)
				RowText(title = "Insurance Fee", price = 8)
			})
//			------------

			CheckoutItem(title = "Payment Method", content = {
				RowText(title = "Service Fee", price = 30)
				RowText(title = "Application Fee", price = 5)
			})
			CheckoutItem(title = "Total", content = {
				Row(
					modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceBetween,
					verticalAlignment = Alignment.CenterVertically
				) {
					Text(
						text = "Total Payment",
						style = MaterialTheme.typography.bodyMedium,
						fontWeight = FontWeight.SemiBold,
						fontFamily = fontInter
					)
					Text(
						text = "$400",
						style = MaterialTheme.typography.bodySmall,
						fontWeight = FontWeight.SemiBold,
						fontFamily = fontInter
					)
				}
			})
			//------

		}
	}
}

@Composable
private fun TitleCard(
	component: @Composable () -> Unit,
	title: String,
	modifier: Modifier = Modifier,
) {
	Row(
		modifier.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(
			text = title,
			style = MaterialTheme.typography.titleLarge,
			fontWeight = FontWeight.Bold,
			fontFamily = fontInter
		)
		component()

	}
}

@Composable
private fun CheckoutItem(
	title: String, content: @Composable ColumnScope.() -> Unit, modifier: Modifier = Modifier
) {
	Card(
		colors = CardDefaults.cardColors(
			containerColor = MaterialTheme.colorScheme.onPrimary
		), elevation = CardDefaults.cardElevation(
			defaultElevation = 1.dp
		)
	) {
		Column(modifier.padding(8.dp)) {
			Text(
				text = title,
				style = MaterialTheme.typography.titleSmall,
				modifier = modifier.padding(5.dp)
			)
			Card(
				colors = CardDefaults.cardColors(
					containerColor = MaterialTheme.colorScheme.primary.copy(
						0.1f
					)
				)
			) {
				Column(
					modifier = modifier.padding(8.dp),
					verticalArrangement = Arrangement.spacedBy(8.dp),
					content = content
				)
			}
		}
	}
}

@Composable
private fun RowText(modifier: Modifier = Modifier, title: String, price: Int) {
	Row(
		modifier.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(
			text = title,
			style = MaterialTheme.typography.bodySmall,
			fontWeight = FontWeight.SemiBold,
			fontFamily = fontInter
		)
		Text(
			text = "$${price}",
			style = MaterialTheme.typography.bodySmall,
			fontWeight = FontWeight.SemiBold,
			fontFamily = fontInter
		)
	}
}

@Preview
@Composable
private fun CheckOutScreenPrev() {
	CheckOutScreen()
}

@Preview
@Composable
private fun PersonDeliveryPrev() {
	PersonDelivery()

}

@Preview
@Composable
private fun PersonCommentPrev() {
	PersonComment()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ListRowProductPrev() {
	ListRowProduct()
}

@Preview
@Composable
private fun VerticalProductPrev() {
	VerticalProduct()
}

@Preview
@Composable
private fun MarketProfileScreenPrev() {
	MarketProfileScreen()
}

@Preview(showBackground = true)
@Composable
private fun CartProductItemPrev() {
	CartProductItem(item = exampleItem)
}

@Preview(showBackground = true)
@Composable
private fun CartProductStatus(modifier: Modifier = Modifier) {

	ElevatedCard(
		modifier = modifier.fillMaxWidth(),
		elevation = CardDefaults.cardElevation(4.dp),
		colors = CardDefaults.cardColors(
//			containerColor = MaterialTheme.colorScheme.onPrimary
		)
	) {
		Column(
			modifier = modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
		) {

			Row(
				modifier = modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Text(
					text = "Shop",
					fontFamily = fontInter,
					style = MaterialTheme.typography.titleLarge,
					fontWeight = FontWeight.Bold,
				)

				FilterChip(
					onClick = {},
					shape = MaterialTheme.shapes.medium,
					label = { Text("Purchased") },
					selected = true,
					colors = FilterChipDefaults.filterChipColors(
						containerColor = MaterialTheme.colorScheme.primaryContainer,
						labelColor = MaterialTheme.colorScheme.primary,
						selectedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
						selectedLabelColor = MaterialTheme.colorScheme.onPrimary
					)
				)
			}

			CartProductItem(
				item = exampleItem
			)

			Row(
				modifier = modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {

				Text(
					text = "Jul 28, 2024",
					fontFamily = fontInter,
					style = MaterialTheme.typography.titleMedium,
				)


				Button(
					onClick = {},
					shape = MaterialTheme.shapes.medium,
				) {
					Text(
						text = "Buy More",
						fontFamily = fontInter,
						style = MaterialTheme.typography.titleSmall,
						fontWeight = FontWeight.Bold
					)
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun CartScreenPrev() {
	CartScreen()
}