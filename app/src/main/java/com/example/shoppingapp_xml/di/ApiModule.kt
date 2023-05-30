package com.example.shoppingapp_xml.di

import android.app.Application
import android.content.Context
import com.example.shoppingapp_xml.network.ApiService
import com.example.shoppingapp_xml.repository.UserRepository
import com.example.shoppingapp_xml.services.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class ApiModule {

    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor().setLevel(Level.BODY)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        return Retrofit.Builder().baseUrl("https://fakestoreapi.com/").client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    fun providesUserRepository(userService: UserService): UserRepository {
        return UserRepository(userService)
    }

    @Singleton
    fun providesUserService(apiService: ApiService): UserService {
        return UserService(apiService)
    }

}