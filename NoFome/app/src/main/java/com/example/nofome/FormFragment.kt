package com.example.nofome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.nofome.databinding.FragmentFormBinding


class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFormBinding.inflate(layoutInflater, container, false)

        binding.btnSave.setOnClickListener {
            insert()
        }

        return binding.root
    }

    private fun validateField(
        name: String,
        description: String,
        value: String,
    ): Boolean{
        return !((name == ""|| name.length > 20)||
                description == "" ||
                value == "")
    }

    private fun insert(){
        val name = binding.ptName.text.toString()
        val description = binding.ptDescription.text.toString()
        val value = binding.ptValue.text.toString()

        if(validateField(name, description, value)){
            Toast.makeText(context, "Cadastrad com sucesso", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_formFragment_to_listFragment)
        }

        else{
            Toast.makeText(context, "Cadastrad com sucesso", Toast.LENGTH_SHORT).show()
        }
    }


}