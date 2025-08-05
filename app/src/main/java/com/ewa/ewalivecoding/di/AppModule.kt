package com.ewa.ewalivecoding.di

import android.content.Context
import com.ewa.analytics.Tracker
import com.ewa.api.BookApi
import com.ewa.api.BookApiBuilder
import com.ewa.ewalivecoding.data.BookRepository
import com.ewa.ewalivecoding.data.BookRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideTracker(): Tracker {
        return Tracker()
    }

    @Provides
    fun provideBookApi(): BookApi {
        return BookApiBuilder.build()
    }

    @Provides
    fun provideBookRepository(
        @ApplicationContext context: Context,
        bookApi: BookApi
    ): BookRepository {
        return BookRepositoryImpl(bookApi, context)
    }
} 