package com.example.examenandroidizder.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.examenandroidizder.database.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
     fun getAll(): List<User>

    @Query("SELECT * FROM User WHERE id = :userId")
     fun getUser(userId: Int): User

    @Query("UPDATE User SET name=:nombre WHERE id=:userId")
     fun updateUser(userId: Int, nombre: String)

    @Insert
     fun insertAll(vararg users: User)

    @Delete
     fun delete(user: User)
}