package com.example.experience.ClearDomain

import com.example.experience.ClearData.MyRepositroy
import com.example.experience.ClearData.RoomRepositoryImpl
import com.example.experience.room.RoomUser

class UseCase(
    private val repositroy: MyRepositroy,
    private val roomRepository: RoomRepositoryImpl
) {
    suspend fun execute(): MutableList<UserModel> {
        val local = repositroy.getData()
        val room = roomRepository.getData()
        val newList: MutableList<UserModel> = mutableListOf()
        newList.addAll(local)
        newList.addAll(room.toUserModelList())
        return newList
    }

    private fun List<RoomUser>.toUserModelList(): List<UserModel> {
        return this.map { it.toUserModel() }
    }

    suspend fun insert(user: RoomUser){
        roomRepository.insert(user)
    }
    private fun RoomUser.toUserModel() = UserModel(name = this.name, lastName = this.lastName)

}