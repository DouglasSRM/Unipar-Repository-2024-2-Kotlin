package br.unipar.provahortasurbanas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class PlantaAdapter(private val context: Context,
                    private val listaPlantas: MutableList<Planta>)
: ArrayAdapter<Planta>(context, 0, listaPlantas) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val planta = listaPlantas.get(position)
        val view = LayoutInflater.from(context).inflate(R.layout.item_planta, parent, false)

        val nome = view.findViewById<TextView>(R.id.txtNamePlant)
        val data = view.findViewById<TextView>(R.id.txtDate)
        val cuidados = view.findViewById<TextView>(R.id.txtCuidado)
        val agua = view.findViewById<TextView>(R.id.txtAgua)

        nome.setText(planta.nome)
        data.setText(planta.data)
        cuidados.setText("Cuidados: " + planta.cuidados)
        agua.setText("Água: necessita de ${planta.agua}ml")

        return view
    }


}
