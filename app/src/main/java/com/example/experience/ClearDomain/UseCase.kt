package com.example.experience.ClearDomain

import com.example.experience.ClearData.MyRepositroy
import com.example.experience.ClearData.RoomRepositoryImpl
import com.example.experience.room.RoomUser

class UseCase(
    private val repositroy: MyRepositroy,
    private val roomRepository: RoomRepositoryImpl
) {
    suspend fun execute(): List<UserModel> {
        val local = repositroy.getData()
        val room = roomRepository.getData()
        return local + room.toUserModelList()
    }

    suspend fun insert(user: RoomUser){
        roomRepository.insert(user)
    }

    private fun List<RoomUser>.toUserModelList(): List<UserModel>{
        return this.map { it.toUserModel() }
    }
    private fun RoomUser.toUserModel() = UserModel(name = this.name, lastName = this.lastName)

}