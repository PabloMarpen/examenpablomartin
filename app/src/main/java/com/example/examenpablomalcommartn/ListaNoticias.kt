package com.example.examenpablomalcommartn

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ListaNoticias : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var spinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.listanoticias)
        spinner = findViewById(R.id.spinner)

        val opciones = arrayOf(
            "Politica",
            "Economia",
            "Cultura",
            "Deportes"
        )

        val ListViewProvincias = findViewById<ListView>(R.id.ListaOpciones)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, provincias)

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
        //val TextView: TextView = findViewById(R.id.textView)
        //TextView.text = spinner.selectedItem.toString()
       // if (p2 == 0){
       //     onNothingSelected(p0)
       // }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}