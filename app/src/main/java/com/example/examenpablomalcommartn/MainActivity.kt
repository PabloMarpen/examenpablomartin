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

    //creamos un broadcast receiver para el modo avion
    private val modoAvion = object : BroadcastReceiver() {
        //un onReceive, si es true lo que nos devuelve lo pasamos a la función
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
        //Creamos un Intent para el modo avión
        registerReceiver(modoAvion, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        //creamos un listener para la imagen que hemos hecho en la vista y usamos un Intent para cargar la siguiente vista
        val imagen = findViewById<ImageView>(R.id.newbutton)

        imagen.setOnClickListener{
            val intent = Intent(this, ListaNoticias::class.java)
            startActivity(intent)
        }

    }
    //Metodo para mostrar los toast del modo avion
    fun mostrarToats(boolean: Boolean){

        if (boolean) {
            Toast.makeText(this, "modo avion on", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "modo avion off", Toast.LENGTH_SHORT).show()
        }
    }
}