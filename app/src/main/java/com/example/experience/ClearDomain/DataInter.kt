package com.example.experience.ClearDomain

import com.example.experience.room.RoomUser

interface DataInter {
    fun getData(): List<UserModel>
//    fun addData(name: String, lastName: String)
//    suspend fun getRoomData()
//    suspend fun insert(user: RoomUser)
}