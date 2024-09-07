package br.unipar.atividade2_1

import android.os.Bundle
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

        val resultado = findViewById<TextView>(R.id.txtResultado)
        val inputIdade = findViewById<EditText>(R.id.edIdade)
        val botaoIdade = findViewById<Button>(R.id.btnIdade)

        botaoIdade.setOnClickListener {

            val idadeInformada = inputIdade.text.toString()

            if(idadeInformada.isNotEmpty()){

                val idadeInt = idadeInformada.toInt()

                if (idadeInt < 18) {
                    resultado.setText("Você é menor de idade.")
                } else if (idadeInt <= 60) {
                    resultado.setText("Você está na meia idade.")
                } else {
                    resultado.setText("Você é idoso.")
                }
            } else {
                resultado.setText("Informe um valor válido!")
            }

        }

    }
}