package com.example.experience.Koin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.experience.ClearData.MyRepositroy
import com.example.experience.ClearDomain.UseCase
import com.example.experience.ClearDomain.UserModel
import kotlinx.coroutines.launch

class MyViewModel(private val useCase: UseCase) : ViewModel() {

    fun loadUser(onResult: (List<UserModel>) -> Unit){
        viewModelScope.launch {
            val users = useCase.execute()
            onResult(users)
        }
    }

    fun addData(name: String, lastNAme: String){
        useCase.addData(name, lastNAme)
    }
}