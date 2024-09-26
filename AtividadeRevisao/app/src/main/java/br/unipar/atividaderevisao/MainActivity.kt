package br.unipar.atividaderevisao

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val listaDeFilmes = mutableListOf<Filme>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edNomeFilme = findViewById<EditText>(R.id.edNomeFilme)
        val edGeneroFilme = findViewById<EditText>(R.id.edGeneroFilme)
        val edAnoLancamento = findViewById<EditText>(R.id.edAnoLancamento)
        val btnAdicionar = findViewById<Button>(R.id.btnAdicionar)
        val listViewFilmes = findViewById<ListView>(R.id.listViewFilmes)

        val adapter = FilmeAdapter(this, listaDeFilmes)
        listViewFilmes.adapter = adapter

        btnAdicionar.setOnClickListener{

            val nome = edNomeFilme.text.toString()
            val genero = edGeneroFilme.text.toString()
            val anoFilme = edAnoLancamento.text.toString()

            if (nome.isEmpty() || genero.isEmpty() || anoFilme.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val anoAtual = SimpleDateFormat("yyyy", Locale.getDefault()).format(Date()).toInt()
            if (anoFilme.toInt() > anoAtual){
                Toast.makeText(this, "Insira um ano válido!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newFilme = Filme(nome,genero,anoFilme)

            listaDeFilmes.add(newFilme)
            adapter.notifyDataSetChanged()

            Toast.makeText(this, "Filme $nome adicionado!", Toast.LENGTH_SHORT).show()

            edNomeFilme.text.clear()
            edGeneroFilme.text.clear()
            edAnoLancamento.text.clear()

        }


    }
}