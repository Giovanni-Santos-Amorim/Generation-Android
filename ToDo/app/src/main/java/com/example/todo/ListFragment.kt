package com.example.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.adapter.TaskAdapter
import com.example.todo.databinding.FragmentListBinding
import com.example.todo.model.Task
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {

    private lateinit var  binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val taskList = listOf(
            Task(
                "Lavar a louça",
                "Lavar a louça o dia todo",
                "Giovanni",
                "2022-05-15",
                false,
                "Dia a dia"
            ),
            Task(
                "Lavar a louça",
                "Lavar a louça o dia todo",
                "Giovanni",
                "2022-05-15",
                false,
                "Dia a dia"
            ),
            Task(
                "Lavar a louça",
                "Lavar a louça o dia todo",
                "Giovanni",
                "2022-05-15",
                false,
                "Dia a dia"
            )
        )

        //config recycler
        val adapter = TaskAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.setHasFixedSize(true)

        adapter.setList(taskList)

        binding.floatingAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        return binding.root
    }
}