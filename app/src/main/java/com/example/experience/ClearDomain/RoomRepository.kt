package com.example.experience.ClearDomain

import com.example.experience.room.RoomUser
import io.reactivex.Completable
import io.reactivex.Single

interface RoomRepository {
    fun getData(): Single<List<RoomUser>>
    fun insert(user: RoomUser): Completable
}