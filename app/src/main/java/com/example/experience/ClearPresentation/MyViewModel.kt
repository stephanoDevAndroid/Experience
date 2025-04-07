package com.example.experience.ClearPresentation

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.experience.ClearDomain.UseCase
import com.example.experience.ClearDomain.UserModel
import com.example.experience.room.RoomUser
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.coroutines.launch

class MyViewModel(private val useCase: UseCase) : ViewModel() {

    private val _users = MutableLiveData<MutableList<UserModel>>()
    val users: LiveData<MutableList<UserModel>> get() = _users

    fun loadUser(context: Context){
        val users = useCase.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {result -> _users.value = result },
                {error -> Toast.makeText(context, error.message.toString(), Toast.LENGTH_SHORT).show()}
            )
    }

    fun insert(user: RoomUser): Completable{
        return useCase.insert(user)
    }
}