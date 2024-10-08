package br.unipar.exemploadapter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val listaDeTarefas = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edTarefa = findViewById<EditText>(R.id.edTarefa)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val listViewTarefas = findViewById<ListView>(R.id.listViewTarefas)

        //Criando uma ponte e usando o layout do android
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDeTarefas)
        //Vinculando o meu adapter com a minha view
        listViewTarefas.adapter  = adapter



        btnCadastrar.setOnClickListener {

            val tarefa = edTarefa.text.toString()

            if(tarefa.isNotEmpty()){

                listaDeTarefas.add(tarefa)
                adapter.notifyDataSetChanged()

                Toast.makeText(this, "Tarefa: $tarefa", Toast.LENGTH_LONG).show()

                edTarefa.text.clear()
            }

        }

        listViewTarefas.setOnItemLongClickListener{ _,_, position,_ ->
            val removeTarefa = listaDeTarefas.removeAt(position)
            adapter.notifyDataSetChanged()
            Toast.makeText(this,"Tarefa removida",Toast.LENGTH_LONG).show()
            true
        }


    }
}