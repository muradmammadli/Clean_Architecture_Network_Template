package com.example.apicleanarc.data.di

import com.example.apicleanarc.data.api.PostApi
import com.example.apicleanarc.data.common.Constants.BASE_URL
import com.example.apicleanarc.data.repository.PostRepositoryImpl
import com.example.apicleanarc.domain.repository.PostRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providePostApi():PostApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApi::class.java)
    }

    @Provides
    @Singleton
    fun providePostRepository(api: PostApi): PostRepository{
        return PostRepositoryImpl(api)
    }



}