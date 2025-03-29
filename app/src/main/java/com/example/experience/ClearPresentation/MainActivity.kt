package com.example.experience.ClearPresentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.experience.R
import com.example.experience.recycleview.RecyclerAdapater
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerAdapater
    private val viewModel: MyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rview = findViewById<RecyclerView>(R.id.r_view)
        val addBtn = findViewById<Button>(R.id.addBtn)
        adapter = RecyclerAdapater(emptyList())

        lifecycleScope.launch {
            viewModel.loadUser { users ->
                adapter.updateData(users)
            }
        }
        rview.adapter = adapter
        rview.layoutManager = LinearLayoutManager(this)

        addBtn.setOnClickListener {
            val intent = Intent(this, fragmentActivity::class.java)
            startActivity(intent)
        }


    }

}