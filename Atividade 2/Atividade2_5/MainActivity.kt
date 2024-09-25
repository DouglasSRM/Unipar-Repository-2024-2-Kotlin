package br.unipar.atividade2_5

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

        val edAltura = findViewById<EditText>(R.id.edAltura)
        val edPeso = findViewById<EditText>(R.id.edPeso)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnCalcular.setOnClickListener {
            val altura = edAltura.text.toString()
            val peso = edPeso.text.toString()

            if (altura.isEmpty() || peso.isEmpty()) {
                txtResultado.text = "Insira os valores."
                return
            }

            val alturaFinal = altura.toDouble()
            val pesoFinal = peso.toDouble()
            val imc = (pesoFinal / (alturaFinal * alturaFinal))

            val imcFinal = String.format("%.2f",imc)

            val resultado: String
            when {
                imc < 18.5 -> resultado = "IMC $imcFinal: Abaixo do peso"
                imc < 25 -> resultado = "IMC $imcFinal: Peso normal"
                imc < 30 -> resultado = "IMC $imcFinal: Sobrepeso"
                else -> resultado = "IMC $imcFinal: Obesidade"
            }
            txtResultado.text = resultado          
        }
    }
    
}
