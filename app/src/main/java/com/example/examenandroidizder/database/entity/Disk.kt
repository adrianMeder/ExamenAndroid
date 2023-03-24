package com.example.examenandroidizder.database.entity

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "disc")
class Disk (
    @PrimaryKey val id: Int,
    val img:String,
    val albumName: String,
    val artistName:String,
    val releaseDate:Date,
    val duration:String
)

