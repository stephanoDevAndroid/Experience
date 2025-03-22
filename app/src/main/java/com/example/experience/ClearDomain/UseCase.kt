package com.example.experience.ClearDomain

import androidx.lifecycle.ViewModel
import com.example.experience.ClearData.MyRepositroy

class UseCase(private val repositroy: MyRepositroy) : ViewModel() {
    suspend fun execute(): List<UserModel> {
        return repositroy.getData()
    }

    fun addData(name: String, lastNAme: String){
        repositroy.addData(name, lastNAme)
    }
}