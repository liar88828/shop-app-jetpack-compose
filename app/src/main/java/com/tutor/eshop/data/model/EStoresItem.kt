package com.tutor.eshop.data.model

import com.tutor.eshop.R
import com.tutor.retrofit_app.eshop.data.model.Rating

data class EStoresItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)

val exampleItem = EStoresItem(
	category = "Electronics movet labores ridiculus neque tempus affert vidisse pertinacia epicuri interpretaris dicant aliquid sapientem auctor docendi error sale eos instructior accumsan dico graeci",
	description = "A high-quality electronic device. movet labores ridiculus neque tempus affert vidisse pertinacia epicuri interpretaris dicant aliquid sapientem auctor docendi error sale eos instructior accumsan dico graeci",
	id = 1,
	image = R.drawable.ic_launcher_foreground.toString(),
	price = 299.99,
	rating = Rating(rate = 4.5, count = 200),
	title = "Smartphone etiam conceptam parturient audire propriae appetere pretium praesent scripserit interpretaris bibendum scripta nunc adhuc sapientem sadipscing conubia erroribus "
)

val exampleItem2 = EStoresItem(
	category = "Electronics movet labores ridiculus neque tempus affert vidisse pertinacia epicuri interpretaris dicant aliquid sapientem auctor docendi error sale eos instructior accumsan dico graeci",
	description = "A high-quality electronic device. movet labores ridiculus neque tempus affert vidisse pertinacia epicuri interpretaris dicant aliquid sapientem auctor docendi error sale eos instructior accumsan dico graeci",
	id = 1,
	image = R.drawable.ic_launcher_foreground.toString(),
	price = 299.99,
	rating = Rating(rate = 4.5, count = 200),
	title = "Smartphone etiam conceptam parturient audire propriae appetere pretium praesent scripserit interpretaris bibendum scripta nunc adhuc sapientem sadipscing conubia erroribus "
)
