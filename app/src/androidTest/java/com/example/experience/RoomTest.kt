package com.example.experience

import androidx.room.Room
import org.junit.Assert.*
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.experience.ClearData.RoomRepositoryImpl
import com.example.experience.room.AppDataBase
import com.example.experience.room.RoomUser
import com.example.experience.room.UserDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RoomTest {

    private lateinit var db: AppDataBase
    private lateinit var userDao: UserDao
    private lateinit var repo: RoomRepositoryImpl

    @Before
    fun setUp(){
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDataBase::class.java
        ).allowMainThreadQueries().build()

        userDao = db.userDao()
        repo = RoomRepositoryImpl(userDao)
    }

    @After
    fun tearDown(){
        db.close()
    }

    @Test
    fun testRoom(){
        val user = RoomUser(name = "Ali", lastName = "Rustamov")
        repo.insert(user).blockingAwait()

        val users = repo.getData().blockingGet()
        assertEquals("Ali", users.last().name)
        assertEquals(1, users.size)
    }

    /*
    suspend -> runBlocking {...}
    Flow<List<T>> -> getData().first()
    LiveData<List<T>> -> getData().getOrAwaitValue()
    */

}