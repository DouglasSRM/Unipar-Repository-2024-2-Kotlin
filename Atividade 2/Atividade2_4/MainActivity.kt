package br.unipar.atividade2_4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

    }

    fun converterValores (view: View) {

        val valorInserido = findViewById<EditText>(R.id.edDolar)
        val taxaInserida = findViewById<EditText>(R.id.edConversao)
        val resultado = findViewById<TextView>(R.id.txtResultado)
        val valorDolar = valorInserido.text.toString()
        val taxa = taxaInserida.text.toString()

        if (valorDolar.isNotEmpty() && taxa.isNotEmpty()) {

            val dolarFloat = valorDolar.toFloat()
            val taxaFloat = taxa.toFloat()
            val valorConvertido = (dolarFloat * taxaFloat)

            val valorFinal = String.format("R$%.2f", valorConvertido)

            resultado.text = "Resultado: $valorFinal"

        } else {
            resultado.text = "Insira valores válidos."
        }

    }


}