package com.tutor.eshop.screen.app.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material.icons.outlined.EmojiEvents
import androidx.compose.material.icons.outlined.Redeem
import androidx.compose.material.icons.outlined.Sell
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tutor.eshop.R
import com.tutor.eshop.screen.app.cart.component.TitleCard
import com.tutor.eshop.screen.app.component.HomeTopAppBar
import com.tutor.eshop.screen.app.component.MyBottomAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
	navController: NavHostController,
//	state: EShopState,
//	onEvent: (EShopEvent) -> Unit,
	modifier: Modifier = Modifier,
) {
	val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

//	LaunchedEffect(key1 = true) {
//		onEvent(EShopEvent.GetProducts)
//	}
	var search = remember {
		mutableStateOf("")
	}
	Scaffold(
		modifier = modifier
			.fillMaxSize()
			.nestedScroll(scrollBehavior.nestedScrollConnection),
		bottomBar = {
			MyBottomAppBar(
				navController
			)
		},
		topBar = {
			HomeTopAppBar(scrollBehavior, modifier, search)
		},
	) { innerPadding ->
		Column(
			modifier = Modifier
				.padding(innerPadding)
				.fillMaxSize(),
//				.verticalScroll(
//					rememberScrollState(),
//				)
//
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.spacedBy(10.dp),
		) {
			ProfileUser()
		}
	}
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProfileUser(modifier: Modifier = Modifier) {
	Column(
		modifier = modifier
			.fillMaxSize()
			.padding(10.dp),
		verticalArrangement = Arrangement.spacedBy(10.dp)
	) {
		Card {
			Row(
				modifier = modifier
					.fillMaxWidth()
					.padding(10.dp),
				horizontalArrangement = Arrangement.SpaceBetween
			) {
				Image(
					painter = painterResource(R.drawable.ic_launcher_foreground),
					contentDescription = "Profile",
					modifier = modifier
						.size(60.dp)
						.clip(CircleShape),

					)
				Column(
					verticalArrangement = Arrangement.spacedBy(5.dp),
				) {
					Text(
						"Florence Bala Anton Aliyah",
						style = MaterialTheme.typography.titleMedium,
						fontWeight = FontWeight.Bold
					)

					FlowRow(
						horizontalArrangement = Arrangement.spacedBy(5.dp),
						maxItemsInEachRow = 2
					) {

						Text(
							"White List ${100}",
							style = MaterialTheme.typography.bodySmall
						)
						Text(
							"Market Follow ${100}",
							style = MaterialTheme.typography.bodySmall
						)
						Text(
							"Vouchers ${100}",
							style = MaterialTheme.typography.bodySmall
						)
					}
				}
				IconButton(
					{}
				) {
					Icon(
						imageVector = Icons.Default.Settings,
						contentDescription = "Icon Setting"
					)
				}
			}
		}


		RewardedDiscounts()
		Card {
			Column(modifier = modifier.padding(10.dp)) {

				TitleCard(
					title = "History",
					component = {
						TextButton(
							onClick = {},
							modifier = modifier.size(height = 20.dp, width = 90.dp),
							contentPadding = PaddingValues(0.dp)
						) {
							Text(text = "See All")
						}
					})
				LazyRow(
					contentPadding = PaddingValues(vertical = 10.dp),
					horizontalArrangement = Arrangement.spacedBy(10.dp)
				) {
					items(exampleHistory) {
						Card(
							modifier.fillMaxWidth(),
							colors = CardDefaults.cardColors(
								containerColor = MaterialTheme.colorScheme.primary
							)
						) {
							Row(
								modifier = modifier
									.fillMaxWidth()
									.padding(horizontal = 20.dp, vertical = 10.dp),
								verticalAlignment = Alignment.CenterVertically
							) {
								IconButton(
									{},
									colors = IconButtonDefaults.iconButtonColors(
										containerColor = statusColor(it.status)
									)
								) {

									Icon(
										imageVector = statusIcon(it.status),
										contentDescription = it.status.name,
										modifier.padding(10.dp),

										)
								}
								Column(modifier.padding(10.dp)) {
									Text(
										"To : ${it.to}",
										style = MaterialTheme.typography.titleMedium
									)
									Text(
										it.product,
										style = MaterialTheme.typography.bodySmall

									)
								}
								Text(
									text = " $${it.price}",
									style = MaterialTheme.typography.titleLarge
								)
							}
						}
					}
				}
			}
		}
	}
}

fun statusIcon(status: STATUS): ImageVector {
	return when (status) {
		STATUS.SUCCESS -> Icons.Default.Check
		STATUS.FAIL -> Icons.Default.Cancel
		STATUS.PROCESS -> Icons.Default.Sync
	}
}

fun statusColor(status: STATUS): Color {
	return when (status) {
		STATUS.SUCCESS -> Color.Green.copy(0.4f)
		STATUS.FAIL -> Color.Red.copy(0.4f)
		STATUS.PROCESS -> Color.Yellow.copy(0.4f)
	}
}

data class History(
	val to: String,
	val product: String,
	val price: Int,
	val status: STATUS
)

enum class STATUS {
	SUCCESS,
	FAIL,
	PROCESS

}

val exampleHistory = listOf(
	History(
		to = "Richard Mia",
		product = "Manoj Vasquez pizza",
		price = 2000,
		status = STATUS.SUCCESS
	),
	History(
		to = "Lucia Ramadan",
		product = "Kyaw Bauri Snack",
		price = 2000,
		status = STATUS.FAIL
	),
)

@Composable
private fun RewardedDiscounts(modifier: Modifier = Modifier) {
	Card {
		Column(
			modifier = modifier
				.fillMaxWidth()
				.padding(10.dp),
			verticalArrangement = Arrangement.spacedBy(10.dp)
		) {

			TitleCard(
				title = "Rewarded and Discounts",
				component = {
					TextButton(
						onClick = {},
						modifier = modifier.size(height = 20.dp, width = 90.dp),
						contentPadding = PaddingValues(0.dp)
					) {
						Text(text = "See All")
					}
				})

			LazyRow(
				horizontalArrangement = Arrangement.spacedBy(20.dp)
			) {
				items(exampleRewardedData) {
					CardRewarded(it, modifier)
				}
			}
		}
	}
}

@Composable
private fun CardRewarded(
	it: RewardedData,
	modifier: Modifier
) {
	Card(
		colors = CardDefaults.cardColors(
			containerColor = it.color
		)
	) {
		Column(modifier.padding(20.dp)) {
			Icon(
				imageVector = it.icon,
				contentDescription = it.title,
				modifier = modifier
					.size(60.dp)
			)
			Text(
				it.title,
				style = MaterialTheme.typography.titleMedium,
				fontWeight = FontWeight.Bold
			)
			Text(
				it.description,
				style = MaterialTheme.typography.bodySmall
			)
		}
	}
}

data class RewardedData(
	val icon: ImageVector,
	val title: String,
	val description: String,
	val color: androidx.compose.ui.graphics.Color,
)

val exampleRewardedData = listOf(
	RewardedData(
		icon = Icons.Outlined.EmojiEvents,
		title = "Achievement",
		description = "200 Reward",
		color = Yellow.copy(alpha = 0.4f)
	),
	RewardedData(
		icon = Icons.Outlined.Sell,
		title = "Offers 30%",
		description = "Click to detail",
		color = Blue.copy(alpha = 0.4f)
	),
	RewardedData(
		icon = Icons.Outlined.Redeem,
		title = "Rewards",
		description = "29 Reward",
		color = Green.copy(alpha = 0.4f)
	)
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProfileUserPrev() {
	ProfileUser()
}