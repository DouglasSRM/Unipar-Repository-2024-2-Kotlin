package com.example.atividadeb21

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.EditText
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MyAdapter

    private var itemList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val edtInput = findViewById<EditText>(R.id.edtInput)
        val addButton = findViewById<Button>(R.id.btnAdd)

        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = MyAdapter(itemList)
        recyclerView.adapter = adapter

        addButton.setOnClickListener {
            val text = edtInput.text.toString()

            if (text.isEmpty()) {
                Toast.makeText(this, "Por favor, insira algum texto", Toast.LENGTH_LONG).show()
            } else {
                itemList.add(text)
                adapter.notifyDataSetChanged()
            }
        }
    }
}
