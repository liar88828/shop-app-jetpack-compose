package com.tutor.eshop.screen.app.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.tutor.eshop.R
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarouselPromo() {
	val pagerState = rememberPagerState(
		initialPage = 0,
		pageCount = { imageSlider.size })

	LaunchedEffect(pagerState) {
		while (true) {
			delay(3000)
			val next =
				if (pagerState.currentPage == imageSlider.size - 1) 0 else pagerState.currentPage + 1
			pagerState.animateScrollToPage(next)
		}

	}

	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
	) {
		HorizontalPager(
			state = pagerState,

			) {
			CarouselItem(
				pagerState,
				it
			)
		}

		LazyRow() {
			items(pagerState.pageCount) {
				Box(
					modifier = Modifier
						.padding(5.dp)
						.size(
							width = if (pagerState.currentPage == it) 40.dp else 15.dp,
							height = 15.dp
						)
						.background(
							color =
							if (pagerState.currentPage == it) MaterialTheme.colorScheme.primaryContainer
							else MaterialTheme.colorScheme.primary,
							shape = MaterialTheme.shapes.medium
						)
				)
			}
		}
	}

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CarouselItem(pagerState: PagerState, it: Int, modifier: Modifier = Modifier) {
	Card(
		modifier = modifier
			.padding(10.dp)
			.height(200.dp)
			.fillMaxHeight()
			.graphicsLayer {
				// Calculate the absolute offset for the current page from the
				// scroll position. We use the absolute value which allows us to mirror
				// any effects for both directions
				val pageOffset = (
						(pagerState.currentPage - it) + pagerState
							.currentPageOffsetFraction
						).absoluteValue

				// We animate the alpha, between 50% and 100%
				alpha = lerp(
					start = 0.5f,
					stop = 1f,
					fraction = 1f - pageOffset.coerceIn(0f, 1f)
				)
			}
	) {
		Row(
			modifier = modifier
				.fillMaxHeight()

		) {
			Column(
				modifier = modifier
					.weight(0.7f)
					.fillMaxHeight()
					.padding(20.dp),
				verticalArrangement = Arrangement.SpaceBetween
			) {
				Column(
					verticalArrangement = Arrangement.spacedBy(5.dp)

				) {
					Text(
						imageSlider[it].title,
						fontWeight = FontWeight.Bold,
//					fontSize = 20.sp
						style = MaterialTheme.typography.titleLarge,
						maxLines = 2
					)
					Text(
						imageSlider[it].description,
//					fontWeight = FontWeight.Light,
//					fontSize = 20.sp,
						style = MaterialTheme.typography.bodySmall,
						maxLines = 2
					)
				}
				Button({}, modifier) {
					Text("Discount ${imageSlider[it].discount}%")
				}
			}
			Image(
				painter = painterResource(imageSlider[it].image),
				contentDescription = "Image slider $it",
				modifier = modifier
					.weight(0.3f)
					.size(180.dp)
					.padding(
						start = 20.dp,
						end = 20.dp,
					)
					.align(
						Alignment.Bottom
					)

			)
		}
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CarouselPromoPrev() {
	CarouselPromo()

}

@Preview
@Composable
@OptIn(ExperimentalFoundationApi::class)
private fun CarouselItemPrev() {
	val pagerState = rememberPagerState(
		initialPage = 0,
		pageCount = { imageSlider.size })

	CarouselItem(
		pagerState = pagerState, 0
	)

}

data class CarouselPromoData(
	val title: String,
	val description: String,
	val discount: Int,
	val image: Int,
)

val imageSlider = listOf(
	CarouselPromoData(
		image = R.drawable.splash_ic,
		description = "peace, samadhi yearns you. consectetuer dis prodesset aptent sem referrentur interdum a est consequat sanctus detraxit fermentum natoque quidam nonumy delectus scripserit vidisse natoque",
		title = "Alide Sousa, If you empower or appear with an ancient",
		discount = 29
	), CarouselPromoData(
		image = R.drawable.splash_ic,
		description = "If you empower or appear with an ancient peace, samadhi yearns you.",
		title = "Alide Sousa",
		discount = 29
	),
	CarouselPromoData(
		image = R.drawable.splash_ic,
		description = "If you empower or appear with an ancient peace, samadhi yearns you.",
		title = "Alide Sousa",
		discount = 29
	),
	CarouselPromoData(
		image = R.drawable.splash_ic,
		description = "If you empower or appear with an ancient peace, samadhi yearns you.",
		title = "Alide Sousa",
		discount = 29
	)
)

