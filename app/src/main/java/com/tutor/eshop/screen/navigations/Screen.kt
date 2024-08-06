package com.tutor.eshop.screen.navigations

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument

fun argScr(
	arg: String,
	argType: NavType<*>
): NamedNavArgument = navArgument(arg) { type = argType }

fun argGetInt(backStackEntry: NavBackStackEntry, key: String) =
	backStackEntry.arguments?.getInt(key) ?: 0

fun argGetStr(backStackEntry: NavBackStackEntry, key: String) =
	backStackEntry.arguments?.getString(key) ?: ""

sealed class Screen(
	val route: String,
) {

	data object OnBoarding : Screen("onboarding")
	data object Home : Screen("home")
	data object Detail : Screen("detail/{id}") {
		fun go(id: Int) = "detail/$id"
	}

	data object Cart : Screen("cart")
	data object Profile : Screen("profile")
	data object Setting : Screen("setting")
	data object Login : Screen("login")
	data object Register : Screen("register")
	data object ForgotPassword : Screen("forgot_password")
	data object ChangePassword : Screen("change_password")
	data object Notification : Screen("notification")
	data object Search : Screen("search")
	data object Checkout : Screen("checkout")
	data object Order : Screen("order")
	data object OrderDetail : Screen("order_detail")
	data object OrderHistory : Screen("order_history")
	data object OrderStatus : Screen("order_status")
	data object OrderTracking : Screen("order_tracking")
	data object OrderReview : Screen("order_review")
	data object OrderReturn : Screen("order_return")
	data object OrderRefund : Screen("order_refund")
	data object OrderCancel : Screen("order_cancel")
	data object OrderExchange : Screen("order_exchange")
	data object OrderReport : Screen("order_report")
	data object OrderHelp : Screen("order_help")
	data object OrderFAQ : Screen("order_faq")
	data object OrderSupport : Screen("order_support")
	data object OrderContact : Screen("order_contact")
	data object OrderAbout : Screen("order_about")
	data object OrderTerms : Screen("order_terms")
	data object OrderPrivacy : Screen("order_privacy")
	data object OrderPolicy : Screen("order_policy")
	data object OrderCookie : Screen("order_cookie")

}

