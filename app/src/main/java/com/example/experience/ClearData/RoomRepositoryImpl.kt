package com.example.experience.ClearData

import com.example.experience.ClearDomain.RoomRepository
import com.example.experience.ClearDomain.UserModel
import com.example.experience.room.RoomUser
import com.example.experience.room.UserDao

class RoomRepositoryImpl(private val userDao: UserDao): RoomRepository {
    override suspend fun getData(): List<RoomUser> {
        return userDao.getALlData()
    }

    override suspend fun insert(user: RoomUser) {
        userDao.insert(user)
    }
}