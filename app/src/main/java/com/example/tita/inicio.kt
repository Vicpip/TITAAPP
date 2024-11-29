package com.example.tita

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnhome: ImageButton = findViewById(R.id.btnHome)
        btnhome.setOnClickListener{
            val intent = Intent(this, inicio::class.java)
            startActivity(intent)
        }

        val btnperfil: ImageButton = findViewById(R.id.btnPerfil)
        btnperfil.setOnClickListener{
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }

        val btnrewards: ImageButton = findViewById(R.id.btnRewards)
        btnrewards.setOnClickListener{
            val intent = Intent(this, recompensas::class.java)
            startActivity(intent)
        }

        val btntita: ImageButton = findViewById(R.id.btnTita)
        btntita.setOnClickListener{
            val intent = Intent(this, inicio::class.java)
            startActivity(intent)
        }

        val btnback: ImageButton = findViewById(R.id.btnBack)
        btnback.setOnClickListener{
            val intent = Intent(this, inicio::class.java)
            startActivity(intent)
        }
    }
}