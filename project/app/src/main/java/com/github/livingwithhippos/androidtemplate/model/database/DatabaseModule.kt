package com.github.livingwithhippos.androidtemplate.model.database

import android.content.Context
import androidx.room.Room
import com.github.livingwithhippos.androidtemplate.model.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): MainDatabase {
        return Room.databaseBuilder(
            appContext,
            MainDatabase::class.java,
            "main_database"
        ).build()
    }

    @Provides
    fun provideUserDao(database: MainDatabase): UserDao {
        return database.userDao()
    }
}