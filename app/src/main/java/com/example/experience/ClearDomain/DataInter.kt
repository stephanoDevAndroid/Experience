package com.example.experience.ClearDomain

interface DataInter {
    suspend fun getData(): List<UserModel>
    fun addData(name: String, lastName: String)
}