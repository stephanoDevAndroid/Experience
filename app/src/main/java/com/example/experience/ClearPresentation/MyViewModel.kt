package com.example.experience.ClearPresentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.experience.ClearDomain.UseCase
import com.example.experience.ClearDomain.UserModel
import com.example.experience.room.RoomUser
import kotlinx.coroutines.launch

class MyViewModel(private val useCase: UseCase) : ViewModel() {

    suspend fun loadUser(onResult: (List<UserModel>) -> Unit){
        val users = useCase.execute()
        onResult(users)
    }

    suspend fun insert(user: RoomUser){
        useCase.insert(user)
    }
}