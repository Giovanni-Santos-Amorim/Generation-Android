package com.example.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        button.setOnClickListener{
            rollDice(6)
        }

        button2.setOnClickListener{
            rollDice(12)
        }

        button3.setOnClickListener{
            rollDice(20)
        }
    }

    private fun rollDice(lados: Int){
        val roll = (1..lados).random()

        val textDice = findViewById<TextView>(R.id.diceText)

        textDice.text = roll.toString()


    }