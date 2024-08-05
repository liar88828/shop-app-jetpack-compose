package com.tutor.eshop.screen

sealed class EStoreRoute(
	val route: String,
) {
	data object Home : EStoreRoute("home")
	data object Detail : EStoreRoute("detail/{id}") {
		fun go(id: Int) = "detail/$id"
	}

	data object Cart : EStoreRoute("cart")
	data object Profile : EStoreRoute("profile")
	data object Setting : EStoreRoute("setting")
	data object Login : EStoreRoute("login")
	data object Register : EStoreRoute("register")
	data object ForgotPassword : EStoreRoute("forgot_password")
	data object ChangePassword : EStoreRoute("change_password")
	data object Notification : EStoreRoute("notification")
	data object Search : EStoreRoute("search")
	data object Checkout : EStoreRoute("checkout")
	data object Order : EStoreRoute("order")
	data object OrderDetail : EStoreRoute("order_detail")
	data object OrderHistory : EStoreRoute("order_history")
	data object OrderStatus : EStoreRoute("order_status")
	data object OrderTracking : EStoreRoute("order_tracking")
	data object OrderReview : EStoreRoute("order_review")
	data object OrderReturn : EStoreRoute("order_return")
	data object OrderRefund : EStoreRoute("order_refund")
	data object OrderCancel : EStoreRoute("order_cancel")
	data object OrderExchange : EStoreRoute("order_exchange")
	data object OrderReport : EStoreRoute("order_report")
	data object OrderHelp : EStoreRoute("order_help")
	data object OrderFAQ : EStoreRoute("order_faq")
	data object OrderSupport : EStoreRoute("order_support")
	data object OrderContact : EStoreRoute("order_contact")
	data object OrderAbout : EStoreRoute("order_about")
	data object OrderTerms : EStoreRoute("order_terms")
	data object OrderPrivacy : EStoreRoute("order_privacy")
	data object OrderPolicy : EStoreRoute("order_policy")
	data object OrderCookie : EStoreRoute("order_cookie")

}