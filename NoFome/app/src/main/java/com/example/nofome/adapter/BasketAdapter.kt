package com.example.nofome.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nofome.databinding.CardLayoutBinding
import com.example.nofome.model.Baskets

class BasketAdapter: RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {

    private var listBaskets = emptyList<Baskets>()

    class BasketViewHolder(val binding: CardLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        return BasketViewHolder(CardLayoutBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        val basket = listBaskets[position]

        holder.binding.tvCardName.text = basket.name
        holder.binding.tvCardDescription.text = basket.description
        holder.binding.tvCardValue.text = basket.value
    }

    override fun getItemCount(): Int {
        return listBaskets.size
    }

    fun setList(list: List<Baskets>){

        listBaskets = list
        notifyDataSetChanged()
    }

}
