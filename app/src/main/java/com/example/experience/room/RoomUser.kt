package com.example.experience.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "user_table")
data class RoomUser(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val lastName: String
)