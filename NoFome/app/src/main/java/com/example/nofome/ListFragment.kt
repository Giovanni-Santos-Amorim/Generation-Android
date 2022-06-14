package com.example.nofome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nofome.adapter.BasketAdapter
import com.example.nofome.databinding.FragmentListBinding
import com.example.nofome.model.Baskets
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val listBaskets = listOf(
            Baskets(
                "Cesta A",
                "Cesta com produtos",
                "50.00"

            ), Baskets(
                "Cesta B",
                "Cesta com produtos",
                "50.00"

            )
        )

        //Recycler view configuration
        val adapter = BasketAdapter()
        binding.rvBasket.layoutManager = LinearLayoutManager(context)
        binding.rvBasket.adapter = adapter
        binding.rvBasket.setHasFixedSize(true)

        adapter.setList(listBaskets)

        binding.fabAddBasket.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        return binding.root
    }
}