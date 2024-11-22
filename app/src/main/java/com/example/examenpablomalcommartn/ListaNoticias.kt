package com.example.examenpablomalcommartn

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.hardware.biometrics.BiometricManager.Strings
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ListaNoticias : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private var Filtro = ""
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

    lateinit var spinner: Spinner
    private var selectedProvince = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.listanoticias)
        spinner = findViewById(R.id.spinner)
        registerReceiver(modoAvion, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))

        val opciones = arrayOf(
            "Politica",
            "Economia",
            "Cultura",
            "Deportes"
        )

        val Titulos = arrayOf(
            "Noticias de politica",
            "Noticias de Economia",
            "Noticias de Cultura",
            "Noticias de Deportes"
        )

        val contenidos = arrayOf(
            "Se ha caido Pedro Sanchez",
            "La economia va mal",
            "Hay un teatro en ns donde",
            "Se ha caido pique"
        )

        val ListViewOpciones = findViewById<ListView>(R.id.ListaOpciones)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, opciones)
        ListViewOpciones.adapter = adapter

        ListViewOpciones.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, _, id ->
                selectedProvince = opciones[id.toInt()]
                Toast.makeText(this, selectedProvince, Toast.LENGTH_SHORT).show()
                if (selectedProvince == "Politica"){
                    val intent = Intent(this, VistaNoticias::class.java)
                    var Titulo = Titulos[0]
                    var contenidos = contenidos[0]
                    intent.putExtra("Titulo", Titulo)
                    intent.putExtra("contenidos", contenidos)
                    if (Titulo == "" || contenidos == ""){
                        Toast.makeText(this, "Introduce todo", Toast.LENGTH_SHORT).show()
                    }else {
                        startActivity(intent)
                    }
                }else if (selectedProvince == "Economia"){
                    val intent = Intent(this, VistaNoticias::class.java)
                    var Titulo = Titulos[1]
                    var contenidos = contenidos[1]
                    intent.putExtra("Titulo", Titulo)
                    intent.putExtra("contenidos", contenidos)
                    if (Titulo == "" || contenidos == ""){
                        Toast.makeText(this, "Introduce todo", Toast.LENGTH_SHORT).show()
                    }else {
                        startActivity(intent)
                    }
                }else if(selectedProvince == "Cultura"){
                    val intent = Intent(this, VistaNoticias::class.java)
                    var Titulo = Titulos[2]
                    var contenidos = contenidos[2]
                    intent.putExtra("Titulo", Titulo)
                    intent.putExtra("contenidos", contenidos)
                    if (Titulo == "" || contenidos == ""){
                        Toast.makeText(this, "Introduce todo", Toast.LENGTH_SHORT).show()
                    }else {
                        startActivity(intent)
                    }
                }else if (selectedProvince == "Deportes"){
                    val intent = Intent(this, VistaNoticias::class.java)
                    var Titulo = Titulos[3]
                    var contenidos = contenidos[3]
                    intent.putExtra("Titulo", Titulo)
                    intent.putExtra("contenidos", contenidos)
                    if (Titulo == "" || contenidos == ""){
                        Toast.makeText(this, "Introduce todo", Toast.LENGTH_SHORT).show()
                    }else {
                        startActivity(intent)
                    }
                }
            }

        if (Filtro == "Politica"){

        }
        ArrayAdapter.createFromResource(
            this, R.array.Seleccion, android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Se especifica el layout para visualizarlo.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // se aplica al spinner el adpatador.
            spinner.adapter = adapter
        }
        //Fijo el listener
        spinner.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val texto = spinner.selectedItem.toString()
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()
        if (selectedProvince == "Politica"){
            Filtro = "Politica"
        }else if (selectedProvince == "Economia"){
            Filtro = "Economia"
        }else if(selectedProvince == "Cultura"){
            Filtro = "Cultura"
        }else if (selectedProvince == "Deportes"){
            Filtro = "Deportes"
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
    fun mostrarToats(boolean: Boolean){

        if (boolean) {
            Toast.makeText(this, "modo avion on", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "modo avion off", Toast.LENGTH_SHORT).show()
        }
    }
}