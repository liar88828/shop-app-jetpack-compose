package com.tutor.eshop.di

import com.tutor.eshop.data.EShopApi
import com.tutor.eshop.utils.ConstEShop
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class EShopModule {

	@Provides
	@Singleton
	fun providerEShop(): String {
		return ConstEShop.BASE_URL
	}

	@Provides
	fun providerLoggingInterceptor(): HttpLoggingInterceptor {
		return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
	}

	@Provides
	fun providerOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
		val okHttpClient = OkHttpClient().newBuilder()
		okHttpClient.callTimeout(40, TimeUnit.SECONDS)
		okHttpClient.connectTimeout(40, TimeUnit.SECONDS)
		okHttpClient.addInterceptor(loggingInterceptor)
		return okHttpClient.build()
	}

	@Provides
	fun providerConvertFactory(): Converter.Factory {
		return GsonConverterFactory.create()
	}

	@Provides
	fun providerRetrofitClient(
		okHttpClient: OkHttpClient,
		baseUrl: String,
		converter: Converter.Factory
	): Retrofit {
		return Retrofit.Builder()
			.baseUrl(baseUrl)
			.client(okHttpClient)
			.addConverterFactory(converter)
			.build()
	}

	@Provides
	fun providerService(retrofit: Retrofit): EShopApi {
		return retrofit.create(EShopApi::class.java)
	}

}