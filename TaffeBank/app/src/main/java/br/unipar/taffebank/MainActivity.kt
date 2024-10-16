package br.unipar.taffebank

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TransacaoAdapter
    private var listaTransacao = mutableListOf<Transacao>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tipoTransacao: Spinner = findViewById<Spinner>(R.id.spTipoTransacao)
        val etValor = findViewById<EditText>(R.id.etValor)
        val etDescricao = findViewById<EditText>(R.id.etDescricao)
        val btnLancar = findViewById<Button>(R.id.btnLancar)
        val viewTransacao = findViewById<RecyclerView>(R.id.rcViewTransacao)

        adapter = TransacaoAdapter(this, listaTransacao)

        viewTransacao.layoutManager = LinearLayoutManager(this)
        viewTransacao.adapter = adapter

        btnLancar.setOnClickListener{
            //Pega da tela principal
            val descricao = etDescricao.text.toString()
            val tipo = tipoTransacao.selectedItem.toString()
            val valor = etValor.text.toString().toDouble()

            //Cria uma nova transação
            val transacao = Transacao(tipo, valor, descricao)
            listaTransacao.add(transacao)

            //Notifica que teve mudança
            adapter.notifyDataSetChanged()



        }
    }
}