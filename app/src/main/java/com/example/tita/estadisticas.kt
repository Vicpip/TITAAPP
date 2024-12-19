package com.example.tita

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class estadisticas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        // Navegación con los botones existentes
        val btnhome: ImageButton = findViewById(R.id.btnHome)
        btnhome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btnperfil: ImageButton = findViewById(R.id.btnPerfil)
        btnperfil.setOnClickListener {
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }

        val btnrewards: ImageButton = findViewById(R.id.btnRewards)
        btnrewards.setOnClickListener {
            val intent = Intent(this, recompensas::class.java)
            startActivity(intent)
        }

        val btnback: ImageButton = findViewById(R.id.btnBack)
        btnback.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Obtener datos enviados desde la actividad "Actividades"
        val ducha = intent.getIntExtra("ducha", 0)
        val dientes = intent.getIntExtra("dientes", 0)
        val platos = intent.getIntExtra("platos", 0)
        val ropa = intent.getIntExtra("ropa", 0)
        val wc = intent.getIntExtra("wc", 0)
        val otro = intent.getIntExtra("otro", 0)
        val nivelTinaco = intent.getIntExtra("nivelTinaco", 1000)

        // Calcular el total de consumo
        val totalConsumo = ducha + dientes + platos + ropa + wc + otro

        // Mensaje dinámico según el nivel del tinaco
        val mensajeDinamico = when {
            nivelTinaco > 800 -> "¡Lo estás haciendo muy bien! Tita está muy contenta contigo."
            nivelTinaco > 500 -> "Vas por buen camino, sigue ahorrando agua."
            nivelTinaco > 200 -> "Atención: El tinaco se está vaciando más rápido."
            else -> "¡Cuidado! El tinaco está casi vacío. Ahorra más agua."
        }

        // Mostrar los consumos y nivel del tinaco con mensaje dinámico
        val textViewEstadisticas: TextView = findViewById(R.id.textViewEstadisticas)
        textViewEstadisticas.text = """
            Ducha: $ducha litros
            Dientes: $dientes litros
            Platos: $platos litros
            Ropa: $ropa litros
            WC: $wc litros
            Otro: $otro litros
            
            Consumo total: $totalConsumo litros
            Nivel del tinaco: $nivelTinaco litros
            
            Mensaje: $mensajeDinamico
        """.trimIndent()
    }
}
