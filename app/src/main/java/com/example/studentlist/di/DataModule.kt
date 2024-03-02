package com.example.studentlist.di

import com.example.studentlist.data.local.dao.StudentDao
import com.example.studentlist.data.remote.ApiService
import com.example.studentlist.data.repository.StudentRepository
import com.example.studentlist.data.repository.StudentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRepository(studentDao: StudentDao, apiService: ApiService): StudentRepository {
        return StudentRepositoryImpl(studentDao, apiService)
    }
}