package br.unipar.exemploadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView

class TarefaAdapter(private val context: Context,
                    private val listaTarefas: MutableList<Tarefa>)
    : ArrayAdapter<Tarefa>(context, 0, listaTarefas) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //Pega a tarefa atual do meu "for"
        val tarefa = listaTarefas.get(position)

        //Aponta qual layout será utilizado
        val view = LayoutInflater.from(context).inflate(R.layout.item_tarefa, parent, false)

        //Pega os campos do layouot escolhido
        val descricao = view.findViewById<TextView>(R.id.txtDescricao)
        val data = view.findViewById<TextView>(R.id.txtData)
        val concluido = view.findViewById<CheckBox>(R.id.cbTarefaConcluida)

        //Joga o valor da tarefa para o campo da tela
        descricao.setText(tarefa.descricao)
        data.setText(tarefa.data)
        concluido.isChecked = tarefa.concluida

        concluido.setOnCheckedChangeListener { _,isChecked ->
            tarefa.concluida = isChecked
        }

        return view
    }



}