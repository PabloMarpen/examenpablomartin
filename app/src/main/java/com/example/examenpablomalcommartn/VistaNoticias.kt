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

    private val modoAvion = object : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {

            val isAirplaneModeOn = intent.getBooleanExtra("state", false)
            if (isAirplaneModeOn){
                mostrarToats(isAirplaneModeOn)
            }else{
                mostrarToats(isAirplaneModeOn)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.vistanoticias)
        registerReceiver(modoAvion, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        val buttonCompartir = findViewById<Button>(R.id.buttonCompartir)
        val tituloNoticia = intent.getStringExtra("Titulo")
        val contenidoNoticia = intent.getStringExtra("contenidos")
        val TextViewtituloNoticia = findViewById<TextView>(R.id.tituloNoticia)
        val TextViewcontenidoNoticia = findViewById<TextView>(R.id.contenidoNoticia)
        TextViewtituloNoticia.text = tituloNoticia
        TextViewcontenidoNoticia.text = contenidoNoticia

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
    fun mostrarToats(boolean: Boolean){

        if (boolean) {
            Toast.makeText(this, "modo avion on", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "modo avion off", Toast.LENGTH_SHORT).show()
        }
    }
}