package com.example.experience.ClearDomain

import com.example.experience.ClearData.MyRepository
import com.example.experience.ClearData.RoomRepositoryImpl
import com.example.experience.room.RoomUser
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class UseCase(
    private val repository: MyRepository,
    private val roomRepository: RoomRepositoryImpl
) {
    fun execute(): Single<MutableList<UserModel>> {
        val local = repository.getData()

        return roomRepository.getData()
            .subscribeOn(Schedulers.io())
            .map { usersFromRoom ->
                val newList = mutableListOf<UserModel>()
                newList.addAll(local)
                newList.addAll(usersFromRoom.toUserModelList())
                newList
            }
    }

    fun insert(user: RoomUser): Completable{
        return roomRepository.insert(user)
    }

    private fun List<RoomUser>.toUserModelList(): List<UserModel> {
        return this.map { it.toUserModel() }
    }
    private fun RoomUser.toUserModel() = UserModel(name = this.name, lastName = this.lastName)

}