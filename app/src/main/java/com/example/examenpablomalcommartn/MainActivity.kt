package com.example.examenpablomalcommartn

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_main)
        registerReceiver(modoAvion, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        val imagen = findViewById<ImageView>(R.id.newbutton)

        imagen.setOnClickListener{
            val intent = Intent(this, ListaNoticias::class.java)
            startActivity(intent)
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