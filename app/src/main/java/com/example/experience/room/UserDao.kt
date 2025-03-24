package com.example.experience.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    fun getALlData(): List<RoomUser>

    @Insert
    suspend fun insert(user: RoomUser)

}