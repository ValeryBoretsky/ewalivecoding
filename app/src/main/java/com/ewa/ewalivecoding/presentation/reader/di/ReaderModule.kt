package com.ewa.ewalivecoding.presentation.reader.di

import com.ewa.analytics.Tracker
import com.ewa.ewalivecoding.presentation.reader.ReaderViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ReaderModule {
    @Provides
    fun provideReaderViewModelFactory(
        tracker: Tracker,
    ): ReaderViewModelFactory {
        return ReaderViewModelFactory(tracker)
    }
}