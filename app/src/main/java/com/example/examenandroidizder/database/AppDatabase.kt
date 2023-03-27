package com.example.examenandroidizder.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examenandroidizder.database.dao.UserDao
import com.example.examenandroidizder.database.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao

}