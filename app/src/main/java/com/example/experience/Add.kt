package com.example.experience

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
const val ARG_PARAM1 = "param1"
const val ARG_PARAM2 = "param2"

//Mapper funksiyalari yaratish
//Agar User va UserEntity ni bir-biriga aylantirish kerak bo‘lsa, mapper funksiya yozing:
//
//fun User.toEntity() = UserEntity(name = this.name, age = this.age)
//fun UserEntity.toUser() = User(name = this.name, age = this.age)
//Shunda siz kerakli joyda User ni UserEntity ga aylantirib ishlatishingiz mumkin.