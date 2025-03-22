package com.example.experience.ClearPresentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.experience.Koin.MyViewModel
import com.example.experience.R
import com.example.experience.recycleview.RecyclerAdapater
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    //    val list = ArrayList<UserModel>()

    private lateinit var adapter: RecyclerAdapater
    private val viewModel: MyViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rview = findViewById<RecyclerView>(R.id.r_view)
        val addBtn = findViewById<Button>(R.id.addBtn)

        viewModel.loadUser { users ->
            adapter = RecyclerAdapater(users)
        }
        rview.adapter = adapter
        rview.layoutManager = LinearLayoutManager(this)

        addBtn.setOnClickListener {
            val intent = Intent(this, fragmentActivity::class.java)
            startActivity(intent)
        }


    }

//    private fun listAdd() {
//        list.add(UserModel("Muhammad", "Rustamov"))
//        list.add(UserModel("Sardor", "Niyazmetov"))
//        list.add(UserModel("Jamshid", "Tutuboyev"))
//        list.add(UserModel("Otabek", "Mahkamov"))
//        list.add(UserModel("Doniyor", "Toxtaboyev"))
//        list.add(UserModel("Polat", "Alemdar"))
//        list.add(UserModel("Andrew", "Lincoln"))
//        list.add(UserModel("Rick", "Grimes"))
//        list.add(UserModel("Carl", "Grime"))
//    }
}