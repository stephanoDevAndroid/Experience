package com.example.experience.ClearPresentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.experience.ARG_PARAM1
import com.example.experience.ARG_PARAM2
import com.example.experience.R
import com.example.experience.room.RoomUser
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class Add : Fragment() {

    private val viewModel: MyViewModel by inject()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val editName = view.findViewById<EditText>(R.id.editName)
        val editLast = view.findViewById<EditText>(R.id.editLst)
        val aply = view.findViewById<Button>(R.id.aply)
        val back = view.findViewById<Button>(R.id.backBtn)

        aply.setOnClickListener {
            lifecycleScope.launch {
                viewModel.insert(
                    RoomUser(
                        name = editName.text.toString(),
                        lastName = editLast.text.toString()
                    )
                )
            }
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)

        }

        back.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Add.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Add().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}