package br.unipar.atividaderevisao

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class FilmeAdapter(private val context: Context, private val listaFilmes: MutableList<Filme>) : ArrayAdapter<Filme>(context, 0, listaFilmes){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val filme = listaFilmes.get(position)

        val view = LayoutInflater.from(context).inflate(R.layout.item_filme, parent, false)

        val nome = view.findViewById<TextView>(R.id.txtNomeFilme)
        val genero = view.findViewById<TextView>(R.id.txtGeneroFilme)
        val ano = view.findViewById<TextView>(R.id.txtAnoLancamento)

        nome.setText(filme.nome)
        genero.setText(filme.genero)
        ano.setText(filme.anoLancamento)

        return view
    }

}