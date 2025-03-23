package com.example.experience.ClearData

import com.example.experience.ClearDomain.DataInter
import com.example.experience.ClearDomain.UserModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyRepositroy() : DataInter {

    private val scope = CoroutineScope(Dispatchers.IO)

    private var list = mutableListOf(
        UserModel("Muhammad", "Rustamov"),
        UserModel("Otabek", "Mahkamov"),
        UserModel("Doniyor", "Toxtaboyev"),
        UserModel("Polat", "Alemdar"),
        UserModel("Andrew", "Lincoln"),
    )


    override suspend fun getData(): List<UserModel> {
        return list
    }

    override fun addData(name: String, lastName: String) {
        list.add(UserModel(name, lastName))
    }


}