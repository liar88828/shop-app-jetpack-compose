package com.tutor.eshop.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class EShopViewModel
@Inject constructor(
	private val repository: EShopRepository

) : ViewModel() {

	private val _state = MutableStateFlow(EShopState())
	val state = _state

	private fun getProducts() {
		_state.value.loading=true
		viewModelScope.launch {
			val response = try {
				repository.getProducts()
			} catch (e: Exception) {
				_state.update {
					it.copy(message = e.message.toString())
				}
				Log.e("TAG_ERROR", "getProducts: ${e.message}")
				return@launch
			} catch (e: HttpException) {
				_state.update {
					it.copy(message = e.message.toString())
				}
				Log.e("TAG_ERROR_HTTP", "getProducts: ${e.message}")
				return@launch
			}
			if (response.isEmpty()) {
				_state.update {
					it.copy(message = "Data IS empty")
				}
			} else {
				_state.update {
					it.copy(
						products = response
					)
				}
			}
			_state.value.loading=false
			Log.e("TAG_SUCCESS", "getProducts: Success")
		}

	}

	private fun getProductMyId(id: Int) {
		_state.value.loading=true
		viewModelScope.launch {
			val response = try {
				repository.getProductId(id)
			} catch (e: Exception) {
				_state.update {
					it.copy(message = e.message.toString())
				}
				Log.e("TAG_ERROR", "getProducts: ${e.message}")
				return@launch
			} catch (e: HttpException) {
				_state.update {
					it.copy(message = e.message.toString())
				}
				Log.e("TAG_ERROR_HTTP", "getProducts: ${e.message}")
				return@launch
			}
			_state.value.product = response
			_state.value.loading=false
			Log.e("TAG_SUCCESS", "getProducts: Success")
		}
	}

	fun onEvent(event: EShopEvent) {
		when (event) {
			is EShopEvent.GetProduct -> {
				getProductMyId(event.id)

			}

			is EShopEvent.GetProducts -> {
				if (state.value.products.isNullOrEmpty()) {
					Log.e("TEST is null", state.value.products.toString())
					getProducts()
				} else {
					Log.e("TEST is Not Null", "TEst")

				}
			}
		}
	}

//	init {
//		getProducts()
//	}

}

