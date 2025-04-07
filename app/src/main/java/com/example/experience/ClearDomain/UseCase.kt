package com.example.experience.ClearDomain

import com.example.experience.ClearData.MyRepositroy
import com.example.experience.ClearData.RoomRepositoryImpl
import com.example.experience.room.RoomUser
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class UseCase(
    private val repositroy: MyRepositroy,
    private val roomRepository: RoomRepositoryImpl
) {
    fun execute(): Single<MutableList<UserModel>> {
        val local = repositroy.getData()

        return roomRepository.getData()
            .subscribeOn(Schedulers.io())
            .map { usersFromRoom ->
                val newList = mutableListOf<UserModel>()
                newList.addAll(local)
                newList.addAll(usersFromRoom.toUserModelList())
                newList
            }
    }

    private fun List<RoomUser>.toUserModelList(): List<UserModel> {
        return this.map { it.toUserModel() }
    }

    fun insert(user: RoomUser): Completable{
        return roomRepository.insert(user)
    }
    private fun RoomUser.toUserModel() = UserModel(name = this.name, lastName = this.lastName)

}