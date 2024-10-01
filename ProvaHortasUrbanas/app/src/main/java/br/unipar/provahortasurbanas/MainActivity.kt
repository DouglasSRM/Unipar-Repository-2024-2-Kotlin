package br.unipar.provahortasurbanas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val listaDePlantas = mutableListOf<Planta>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ConstraitLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edNamePlant = findViewById<EditText>(R.id.edNamePlant)
        val rdbtnBaixo = findViewById<RadioButton>(R.id.rdbtnBaixo)
        val rdbtnMedio = findViewById<RadioButton>(R.id.rdbtnMedio)
        val edQtdAgua = findViewById<EditText>(R.id.edQtdAgua)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val listViewPlantas = findViewById<ListView>(R.id.listViewPlantas)
        val txtPlantasTotal = findViewById<TextView>(R.id.txtPlantasTotal)
        var contadorPlantas = 0

        val adapter = PlantaAdapter(this, listaDePlantas)

        listViewPlantas.adapter = adapter

        rdbtnBaixo.isChecked = true

        btnInserir.setOnClickListener {

            if (edNamePlant.text.isEmpty() || edQtdAgua.text.isEmpty()) {
                Toast.makeText(this,"Insira todos os dados necessários!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val nome = edNamePlant.text.toString()
            val data = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
            val cuidados = if (rdbtnBaixo.isChecked) { "Baixo"}
                else if (rdbtnMedio.isChecked) {"Medio"}
                else {"Alto"}

            val aguaStr = edQtdAgua.text.toString()
            val agua = aguaStr.toInt()

            val novaPlanta = Planta(nome,data,cuidados,agua)
            listaDePlantas.add(novaPlanta)
            adapter.notifyDataSetChanged()

            Toast.makeText(this, "Planta $nome adicionada", Toast.LENGTH_SHORT).show()
            contadorPlantas++
            txtPlantasTotal.text = "Plantas Cultivadas: ${contadorPlantas}"

            edNamePlant.text.clear()
            edQtdAgua.text.clear()
            rdbtnBaixo.isChecked = true
        }

        listViewPlantas.setOnItemLongClickListener{_,_, position,_ ->
            val nome = listaDePlantas[position].nome
            val removePlanta = listaDePlantas.removeAt(position)
            adapter.notifyDataSetChanged()
            Toast.makeText(this,"Planta ${nome} removida",Toast.LENGTH_SHORT).show()
            contadorPlantas--
            txtPlantasTotal.text = "Plantas Cultivadas: ${contadorPlantas}"
            true
        }

    }
}