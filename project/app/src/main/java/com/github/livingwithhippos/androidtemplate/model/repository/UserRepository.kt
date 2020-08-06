package com.github.livingwithhippos.androidtemplate.model.repository

import com.github.livingwithhippos.androidtemplate.model.dao.UserDao
import com.github.livingwithhippos.androidtemplate.model.entities.User
import javax.inject.Inject

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class CredentialsRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun getAll() = userDao.getAll()

    suspend fun getUser(name: String) = userDao.getUser(name)

    suspend fun insert(user: User) = userDao.insert(user)

    suspend fun updateUser(user: User) =
        userDao.update(user)

    suspend fun deleteAll() = userDao.deleteAll()

    suspend fun delete(name: String) = userDao.delete(name)

}