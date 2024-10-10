package br.unipar.taffebank

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransacaoAdapter(private val context: Context, private val transacoes: List<Transacao>)
    : RecyclerView.Adapter<TransacaoAdapter.ViewHolder>(){


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val tvDescricao = itemView.findViewById<TextView>(R.id.tvDescricao)
        val tvTipo = itemView.findViewById<TextView>(R.id.tvTipo)
        val tvValor = itemView.findViewById<TextView>(R.id.tvValor)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransacaoAdapter.ViewHolder {
        //busca o layout que vai ser inflado para o novo item
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout_transacao, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransacaoAdapter.ViewHolder, position: Int) {

        val itemTransacao = transacoes[position]
        holder.tvDescricao.text = itemTransacao.descricao
        holder.tvTipo.text = itemTransacao.tipo
        holder.tvValor.text = itemTransacao.valor.toString()

    }

    override fun getItemCount(): Int {
        return transacoes.size
    }
}