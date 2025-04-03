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

    private var list = mutableListOf(
        UserModel("Muhammad", "Rustamov"),
        UserModel("Otabek", "Mahkamov"),
        UserModel("Doniyor", "Toxtaboyev"),
        UserModel("Polat", "Alemdar"),
        UserModel("Andrew", "Lincoln"),
    )

    override fun getData(): MutableList<UserModel> {
        return list
    }
}