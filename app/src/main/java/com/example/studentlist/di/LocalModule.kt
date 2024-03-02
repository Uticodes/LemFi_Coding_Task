package com.example.studentlist.di

import android.content.Context
import androidx.room.Room
import com.example.studentlist.data.local.StudentDataBase
import com.example.studentlist.data.local.dao.StudentDao
import com.example.studentlist.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun providesStudentDataBase(@ApplicationContext context: Context): StudentDataBase {
        return Room.databaseBuilder(context, StudentDataBase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideStudentDao(studentDatabase: StudentDataBase): StudentDao = studentDatabase.studentDao()
}