package com.example.experience.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RoomUser::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): RoomDatabase{
            return INSTANCE ?: synchronized(this){
                var instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "table_name"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }
}