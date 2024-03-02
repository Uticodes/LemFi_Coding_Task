package com.example.studentlist.di

import com.example.studentlist.dispatcher.DispatcherHelper
import com.example.studentlist.dispatcher.DispatcherHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDispatcherHelper(): DispatcherHelper = DispatcherHelperImpl()
}
