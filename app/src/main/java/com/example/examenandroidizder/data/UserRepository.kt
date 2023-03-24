package com.example.examenandroidizder.data

import com.example.examenandroidizder.database.entity.User

interface UserRepository {

    fun getAllUsers(): List<User>
    fun getUser(userId: Int): User
    fun addUser(user: User)
    fun deleteUser(user: User)

}