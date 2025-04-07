package com.example.experience.ClearData

import com.example.experience.ClearDomain.RoomRepository
import com.example.experience.ClearDomain.UserModel
import com.example.experience.room.RoomUser
import com.example.experience.room.UserDao
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class RoomRepositoryImpl(private val userDao: UserDao): RoomRepository {
    override fun getData(): Single<List<RoomUser>> {
        return userDao.getALlData()
    }


    override fun insert(user: RoomUser): Completable {
        return userDao.insert(user)
    }
}