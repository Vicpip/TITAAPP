package com.example.tita

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Activdades : AppCompatActivity() {

    private var duchaConsumo = 0
    private var dientesConsumo = 0
    private var platosConsumo = 0
    private var ropaConsumo = 0
    private var wcConsumo = 0
    private var otroConsumo = 0
    private var nivelTinaco = 1000 // Capacidad inicial del tinaco en litros

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividades)

        // Configuración de navegación
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

        // Configuración de botones para agregar consumo
        val btnDucha: ImageButton = findViewById(R.id.btnDucha)
        val btnDientes: ImageButton = findViewById(R.id.btnDientes)
        val btnPlatos: ImageButton = findViewById(R.id.btnPlatos)
        val btnRopa: ImageButton = findViewById(R.id.btnRopa)
        val btnWC: ImageButton = findViewById(R.id.btnWC)
        val btnOtro: ImageButton = findViewById(R.id.btnOtro)
        val btnVerEstadisticas: ImageButton = findViewById(R.id.btnVerEstadisticas)

        btnDucha.setOnClickListener { registrarConsumo("Ducha", 20) }
        btnDientes.setOnClickListener { registrarConsumo("Dientes", 5) }
        btnPlatos.setOnClickListener { registrarConsumo("Platos", 15) }
        btnRopa.setOnClickListener { registrarConsumo("Ropa", 10) }
        btnWC.setOnClickListener { registrarConsumo("WC", 10) }
        btnOtro.setOnClickListener { preguntarConsumoOtro() }

        // Enviar consumos y nivel del tinaco a estadísticas
        btnVerEstadisticas.setOnClickListener {
            val intent = Intent(this, estadisticas::class.java).apply {
                putExtra("ducha", duchaConsumo)
                putExtra("dientes", dientesConsumo)
                putExtra("platos", platosConsumo)
                putExtra("ropa", ropaConsumo)
                putExtra("wc", wcConsumo)
                putExtra("otro", otroConsumo)
                putExtra("nivelTinaco", nivelTinaco)
            }
            startActivity(intent)
        }
    }

    private fun registrarConsumo(actividad: String, litros: Int) {
        if (nivelTinaco >= litros) {
            when (actividad) {
                "Ducha" -> duchaConsumo += litros
                "Dientes" -> dientesConsumo += litros
                "Platos" -> platosConsumo += litros
                "Ropa" -> ropaConsumo += litros
                "WC" -> wcConsumo += litros
                "Otro" -> otroConsumo += litros
            }
            nivelTinaco -= litros // Reducir el nivel del tinaco
            Toast.makeText(this, "Añadido $litros litros a $actividad. Tinaco: $nivelTinaco litros restantes", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "No hay suficiente agua en el tinaco para este consumo", Toast.LENGTH_SHORT).show()
        }
    }

    private fun preguntarConsumoOtro() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Otro consumo")
        dialog.setMessage("¿De cuánto fue el consumo en litros?")
        val input = android.widget.EditText(this)
        input.inputType = android.text.InputType.TYPE_CLASS_NUMBER
        dialog.setView(input)

        dialog.setPositiveButton("Agregar") { _, _ ->
            val litros = input.text.toString().toIntOrNull() ?: 0
            if (litros > 0) {
                registrarConsumo("Otro", litros)
            } else {
                Toast.makeText(this, "Por favor ingresa un número válido", Toast.LENGTH_SHORT).show()
            }
        }

        dialog.setNegativeButton("Cancelar") { dialogInterface, _ ->
            dialogInterface.dismiss()
        }

        dialog.show()
    }
}
