package com.example.tita

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class recompensas : AppCompatActivity() {

    private var puntos = 0
    private val insignias = mutableListOf("Ahorrista Novato", "Guardian del Agua")
    private val consejos = listOf(
        "Cierra la llave mientras te cepillas los dientes.",
        "Usa el agua de lluvia para regar tus plantas.",
        "Repara fugas en las tuberías para evitar desperdicios.",
        "Usa un balde en lugar de una manguera para lavar el coche."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recompensas)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configuración de botones de navegación
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

        val btntita: ImageButton = findViewById(R.id.btnTita)
        btntita.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btnback: ImageButton = findViewById(R.id.btnBack)
        btnback.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Configuración de recompensas
        val textViewPuntos: TextView = findViewById(R.id.textViewPuntos)
        val listViewInsignias: ListView = findViewById(R.id.listViewInsignias)
        val textViewConsejo: TextView = findViewById(R.id.textViewConsejo)

        // Mostrar puntos acumulados
        puntos = calcularPuntos() // Método para calcular puntos
        textViewPuntos.text = "Puntos: $puntos"

        // Mostrar insignias
        val adapter = android.widget.ArrayAdapter(this, android.R.layout.simple_list_item_1, insignias)
        listViewInsignias.adapter = adapter

        // Mostrar un consejo aleatorio
        textViewConsejo.text = "Consejo: ${consejos.random()}"
    }

    private fun calcularPuntos(): Int {
        // Simulación de cálculo de puntos. Puedes conectar esto a tu lógica real.
        return (insignias.size * 50) // Cada insignia vale 50 puntos
    }
}
