package com.example.examenpablomalcommartn

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val imagen = findViewById<ImageView>(R.id.newbutton)

        imagen.setOnClickListener{
            val intent = Intent(this, ListaNoticias::class.java)
            startActivity(intent)
        }

    }
}