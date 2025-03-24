package com.example.experience.ClearData

import com.example.experience.ClearDomain.DataInter
import com.example.experience.ClearDomain.UserModel
import com.example.experience.room.RoomUser
import com.example.experience.room.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MyRepositroy(private val userDao: UserDao) : DataInter {

    private val scope = CoroutineScope(Dispatchers.IO)

    init {
        scope.launch {
            getRoomData()
        }
    }

    private var list = mutableListOf(
        UserModel("Muhammad", "Rustamov"),
        UserModel("Otabek", "Mahkamov"),
        UserModel("Doniyor", "Toxtaboyev"),
        UserModel("Polat", "Alemdar"),
        UserModel("Andrew", "Lincoln"),
    )

    override fun getData(): List<UserModel> {
        return list
    }

    override fun addData(name: String, lastName: String) {
        list.add(UserModel(name, lastName))
        scope.launch {
            insert(RoomUser(name = name, lastName = lastName))
        }
    }

    override suspend fun getRoomData() {
        val users = userDao.getALlData()
        users.forEach {user ->
            list.add(user.toUserModel())
        }
    }

    override suspend fun insert(user: RoomUser) {
        userDao.insert(user)
    }

    private fun RoomUser.toUserModel() = UserModel(
        name = this.name,
        lastName = this.lastName
    )



}