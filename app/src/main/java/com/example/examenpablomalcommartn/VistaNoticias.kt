package com.example.examenpablomalcommartn

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class VistaNoticias : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.vistanoticias)

        //inicializaciones de la vista
        val buttonCompartir = findViewById<Button>(R.id.buttonCompartir)
        // pillamos los intents que llegan de la otra actividad
        val tituloNoticia = intent.getStringExtra("Titulo")
        val contenidoNoticia = intent.getStringExtra("contenidos")
        val TextViewtituloNoticia = findViewById<TextView>(R.id.tituloNoticia)
        val TextViewcontenidoNoticia = findViewById<TextView>(R.id.contenidoNoticia)
        // ponemos el contenido pasado por los intents
        TextViewtituloNoticia.text = tituloNoticia
        TextViewcontenidoNoticia.text = contenidoNoticia

        //listener del boton compartir con su Intent para compartir texto
        buttonCompartir.setOnClickListener{
            var contenidoCompartir = TextViewcontenidoNoticia.text.toString()
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "$contenidoCompartir")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }


    }

}