package com.github.livingwithhippos.androidtemplate.model.dao

import androidx.room.*
import com.github.livingwithhippos.androidtemplate.model.entities.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE name = :name")
    suspend fun getUser(name: String): User

    @Query("SELECT * from user")
    suspend fun getAll(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Query("DELETE FROM user")
    suspend fun deleteAll()

    @Query("DELETE FROM user WHERE name = :name")
    suspend fun delete(name: String)
}