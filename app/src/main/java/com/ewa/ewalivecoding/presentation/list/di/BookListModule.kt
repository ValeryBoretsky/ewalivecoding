package com.ewa.ewalivecoding.presentation.list.di

import android.content.Context
import com.ewa.api.BookApi
import com.ewa.api.BookApiBuilder
import com.ewa.ewalivecoding.data.BookRepositoryImpl
import com.ewa.ewalivecoding.domain.BookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object BookListModule {

    @Provides
    fun provideBookApi(): BookApi {
        return BookApiBuilder.build()
    }

    @Provides
    fun provideRepository(@ApplicationContext context: Context, bookApi: BookApi): BookRepository {
        return BookRepositoryImpl(bookApi, context)
    }

}