package com.example.experience.Koin

import android.content.Context
import androidx.room.Room
import com.example.experience.ClearData.MyRepositroy
import com.example.experience.ClearData.RoomRepositoryImpl
import com.example.experience.ClearDomain.DataInter
import com.example.experience.ClearDomain.UseCase
import com.example.experience.ClearPresentation.MyViewModel
import com.example.experience.room.AppDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { get<AppDataBase>().userDao() }
    single { MyRepositroy(get()) }
    single { RoomRepositoryImpl(get()) }
    factory { UseCase(get(), get()) }
    factory { MyViewModel(get()) }
}
val dataBaseModule = module {
    single { getAppDataBase(androidContext()) }
    single { get<AppDataBase>().userDao() }
    single<DataInter> { MyRepositroy(get()) }
}
fun getAppDataBase(context: Context): AppDataBase{
    return Room.databaseBuilder(
        context.applicationContext,
        AppDataBase::class.java,
        "app_database"
    ).build()
}