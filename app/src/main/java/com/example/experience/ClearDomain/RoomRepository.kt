package com.example.experience.ClearDomain

import com.example.experience.room.RoomUser

interface RoomRepository {
    suspend fun getAllData(): List<RoomUser>
    suspend fun insert(user: RoomUser)
}