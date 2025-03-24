package com.example.experience.ClearDomain

import androidx.lifecycle.ViewModel
import com.example.experience.ClearData.MyRepositroy
import com.example.experience.room.RoomUser

class UseCase(private val repositroy: MyRepositroy) {
    fun execute(): List<UserModel> {
        return repositroy.getData()
    }

    fun addData(name: String, lastNAme: String){
        repositroy.addData(name, lastNAme)
    }

    suspend fun insert(user: RoomUser){
        repositroy.insert(user)
    }
}