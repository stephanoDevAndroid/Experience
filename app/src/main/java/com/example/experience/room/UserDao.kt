package com.example.experience.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    fun getALlData(): Single<List<RoomUser>>

    @Insert
    fun insert(user: RoomUser): Completable

}