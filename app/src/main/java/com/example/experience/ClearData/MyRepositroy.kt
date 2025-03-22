package com.example.experience.ClearData

import com.example.experience.ClearDomain.DataInter
import com.example.experience.ClearDomain.UserModel

class MyRepositroy() : DataInter {

    private var list = mutableListOf(
        UserModel("Muhammad", "Rustamov"),
        UserModel("Otabek", "Mahkamov"),
        UserModel("Doniyor", "Toxtaboyev"),
        UserModel("Polat", "Alemdar"),
        UserModel("Andrew", "Lincoln"),
        UserModel("Rick", "Grimes"),
        UserModel("Carl", "Grime")
    )

    override suspend fun getData(): List<UserModel> {
        return list
    }

    override fun addData(name: String, lastName: String) {
        list.add(UserModel(name, lastName))
    }


}