package br.unipar.taffebank

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
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

        btnLancar.setOnClickListener{

            println("Cliquei no Botão")
            println(tipoTransacao.selectedItem.toString())

        }
    }
}