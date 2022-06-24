package com.generation.todolist.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.generation.todolist.MainViewModel
import com.generation.todolist.databinding.CardLayoutBinding
import com.generation.todolist.model.Tarefa

class TarefaAdapter(
    val taskClickListener: TaskClickListener,
    val mainViewModel: MainViewModel,
    val context: Context
): RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    var listTarefa = emptyList<Tarefa>()

    class TarefaViewHolder(val binding: CardLayoutBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        return TarefaViewHolder(
            CardLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        )
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = listTarefa[position]

        holder.binding.textNome.text = tarefa.nome
        holder.binding.textDescricao.text = tarefa.descricao
        holder.binding.textResponsavel.text = tarefa.responsavel
        holder.binding.textData.text = tarefa.data
        holder.binding.switchAtivo.isChecked = tarefa.status
        holder.binding.textCategoria.text = tarefa.categoria.descricao

        holder.binding.cardView.setOnClickListener {
            taskClickListener.onTaskClickListener(tarefa)
        }
        
        holder.binding.switchAtivo.setOnCheckedChangeListener { buttonView, ativo ->
            tarefa.status = ativo

            mainViewModel.updateTarefa(tarefa)
        }

        holder.binding.buttonDeletar.setOnClickListener{
            showAlertDialog(tarefa.id)
        }
    }

    override fun getItemCount(): Int {
        return listTarefa.size
    }

    fun setList(list: List<Tarefa>){
        listTarefa = list.sortedByDescending { it.id }
        notifyDataSetChanged()
    }

    private fun showAlertDialog(id: Long)
    {
        AlertDialog.Builder(context)
            .setTitle("Excluir tarefa")
            .setMessage("Deseja excluir a tarefa?")
            .setPositiveButton("sim"){
                _,_ -> mainViewModel.deleteTarefa(id)
            }
            .setNegativeButton("não"){
                _,_ ->
            }.show()
    }
}