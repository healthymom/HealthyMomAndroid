package kz.healthymom.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.readystatesoftware.chuck.ChuckInterceptor
import kz.healthymom.network.AuthService
import kz.healthymom.presentation.base.HealthyMomApp
import kz.healthymom.presentation.utils.HealthyMomConstant
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.Builder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.SECONDS

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
val networkModule = module {
    single { getOkHttpClient() }
    single { getRetrofit(get()) }
    single { createAuthService(get()) }
}

fun createAuthService(retrofit: Retrofit): AuthService {
    return retrofit.create(AuthService::class.java)
}


fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(HealthyMomConstant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(okHttpClient)
        .build()
}

fun getRetrofit2(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.kmf.kz:8443/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(okHttpClient)
        .build()
}

fun getOkHttpClient(): OkHttpClient {
    return Builder()
        .followRedirects(true)
        .followSslRedirects(true)
        .retryOnConnectionFailure(true)
        .cache(null)
        .addInterceptor(ChuckInterceptor(HealthyMomApp.CONTEXT))
        .addInterceptor {
            val requestBuilder = it.request().newBuilder()
                .addHeader("Authorization", "Bearer ${HealthyMomConstant.TOKEN}")
            it.proceed(requestBuilder.build())
        }
        .connectTimeout(20, SECONDS)
        .writeTimeout(20, SECONDS)
        .readTimeout(20, SECONDS)
        .build()
}