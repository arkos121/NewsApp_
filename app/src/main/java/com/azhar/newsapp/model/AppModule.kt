package com.azhar.newsapp.model

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.intellij.lang.annotations.PrintFormat
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWebVIewManager(): webViewInterface {
        return webViewInterfaceImpl()
    }

    @Provides
    @Singleton
    fun provideNewsRepository() : NewsRepository {
        return NewsRepository()
    }
    }

