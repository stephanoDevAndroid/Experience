package com.example.experience.ClearPresentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.experience.ClearDomain.UseCase
import com.example.experience.ClearDomain.UserModel
import com.example.experience.room.RoomUser
import kotlinx.coroutines.launch

class MyViewModel(private val useCase: UseCase) : ViewModel() {

    private val _users = MutableLiveData<MutableList<UserModel>>()
    val users: LiveData<MutableList<UserModel>> get() = _users

    fun loadUser(){
        viewModelScope.launch {
            val users = useCase.execute()
            _users.value = users
        }
    }

    suspend fun insert(user: RoomUser){
        useCase.insert(user)
    }
}