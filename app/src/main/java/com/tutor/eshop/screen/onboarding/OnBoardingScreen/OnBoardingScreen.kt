package com.tutor.eshop.screen.onboarding.OnBoardingScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tutor.eshop.R
import com.tutor.eshop.viewmodel.onboarding.OnBoardingEvent
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
//	viewModel: OnBoardingViewModel = hiltViewModel<OnBoardingViewModel>(),
	onEvent: (OnBoardingEvent) -> Unit,
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
			.fillMaxSize()
			.background(
				color = MaterialTheme.colorScheme.onPrimary
			)
	) {
		val pagerState = rememberPagerState(initialPage = 0) {
			onBoardingList.size
		}
		val currentPage = pagerState.currentPage
		val scope = rememberCoroutineScope()
		HorizontalPager(state = pagerState) {
			OnBoardingContent(
				page = onBoardingList[it]
			)
		}
		Spacer(modifier.weight(1f))
		Row(
			modifier = modifier
				.fillMaxWidth()
				.padding(horizontal = 16.dp, vertical = 32.dp),
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically
		) {
			IndicatorDot(
				pageSize = onBoardingList.size,
				pageCurrent = currentPage
			)
			NextBackButton(
				pageSize = onBoardingList.size,
				pageCurrent = currentPage,
				onBack = {
					scope.launch {
						pagerState.animateScrollToPage(page = currentPage - 1)
					}
				},
				onNext = {
					scope.launch {
						pagerState.animateScrollToPage(page = currentPage + 1)
					}
				},
				onStart = {
//					viewModel.saveAppEntry()
					onEvent(OnBoardingEvent.saveAppEntry)
				}
			)
		}
	}

}

@Composable
fun OnBoardingContent(
	page: OnBoardingData,
	modifier: Modifier = Modifier
) {
	Column() {
		Image(
			painter = painterResource(id = page.image),
			contentDescription = page.title,
			modifier = modifier
				.fillMaxWidth()
				.fillMaxHeight(.6f),
			contentScale = ContentScale.Crop
		)
		Column(
			modifier = modifier.padding(
				horizontal = 18.dp,
				vertical = 2.dp
			)
		) {

			Text(
				text = page.title,
				style = MaterialTheme.typography.headlineMedium,
				fontWeight = FontWeight.Medium,
			)
			Text(
				text = page.description,
				style = MaterialTheme.typography.bodyLarge,
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun OnBoardingScreenPrev() {
	OnBoardingScreen(
		onEvent = {},
		)

}

@Preview(showBackground = true)
@Composable
private fun OnBoardingContentPrev() {
	OnBoardingContent(
		page = OnBoardingData(
			title = "title",
			description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam",
			image = R.drawable.obs_1
		)
	)
}