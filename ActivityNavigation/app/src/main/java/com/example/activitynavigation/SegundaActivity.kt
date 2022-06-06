package com.example.activitynavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        val buttonSave = findViewById<Button>(R.id.buttonSave)

        buttonSave.setOnClickListener{
            finish()
        }
    }
}