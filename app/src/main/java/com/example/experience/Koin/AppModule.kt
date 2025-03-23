package com.example.experience.Koin

import com.example.experience.ClearData.MyRepositroy
import com.example.experience.ClearDomain.UseCase
import org.koin.dsl.module
import kotlin.math.sin

val appModule = module {
    single { MyRepositroy() }
    single { UseCase(get()) }
    factory { MyViewModel(get()) }
}