package com.example.experience.ClearData

import com.example.experience.ClearDomain.RoomRepository
import com.example.experience.ClearDomain.UserModel
import com.example.experience.room.RoomUser
import com.example.experience.room.UserDao

class RoomRepositoryImpl(private val userDao: UserDao): RoomRepository {
    override suspend fun getAllData(): List<RoomUser> {
        return userDao.getALlData()
    }

    override suspend fun insert(user: RoomUser) {
        userDao.insert(user)
    }

    private fun RoomUser.toUserModel() = UserModel(name = this.name, lastName = this.lastName)


}