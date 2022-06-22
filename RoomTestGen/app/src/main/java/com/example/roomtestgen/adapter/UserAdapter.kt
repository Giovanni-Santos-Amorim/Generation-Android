package com.example.roomtestgen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomtestgen.data.Usuario
import com.example.roomtestgen.databinding.CardLayoutBinding

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var listUser = emptyList<Usuario>()

    class UserViewHolder(val binding: CardLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(CardLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listUser[position]

        holder.binding.tvId.text = user.id.toString()
        holder.binding.tvNome.text = user.nome
        holder.binding.tvSobrenome.text = user.sobrenome
        holder.binding.tvIdade.text = user.idade.toString()
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    fun setList(list: List<Usuario>)
    {
        listUser = list
        notifyDataSetChanged()
    }
}