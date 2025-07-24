package com.example.domain.network.di

import com.example.domain.network.ApiInterface
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideGson() = GsonBuilder().create()

    @Provides
    fun okHttpClicked() : OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    fun provideRetrofit(
        gson: Gson,
        okHttpClient: OkHttpClient
    ) : Retrofit {
            return Retrofit.Builder()
                .baseUrl("http://Your_base_url")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @Singleton
    @Provides
    fun apiService(
        retrofit: Retrofit
    ) : ApiInterface = retrofit.create(ApiInterface::class.java)
}
