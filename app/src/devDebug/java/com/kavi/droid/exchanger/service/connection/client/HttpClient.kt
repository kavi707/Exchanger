package com.kavi.droid.exchanger.service.connection.client

import com.kavi.droid.exchanger.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.mock.MockRetrofit

class HttpClient {

    companion object {
        private const val MOCK_BASE_URL = "http://localhost/mock"

        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.HEADERS
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        private val client: OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()

        fun create(): DebugExchangerMapService {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BuildConfig.SERVER_URL)
                    .client(client)
                    .build()

            val mockRetrofit = MockRetrofit.Builder(retrofit).build();

            val mockExchangerMapService = DebugExchangerMapService(mockRetrofit)
            return mockExchangerMapService;
        }
    }
}