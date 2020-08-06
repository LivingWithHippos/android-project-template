package com.github.livingwithhippos.androidtemplate.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.livingwithhippos.androidtemplate.model.dao.UserDao
import com.github.livingwithhippos.androidtemplate.model.entities.User

// Annotates class to be a Room Database with a table (entity) of the Credentials class
@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
public abstract class MainDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}