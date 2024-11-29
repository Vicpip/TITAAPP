package com.example.tita

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnactividad: Button = findViewById(R.id.btnActividad)
        btnactividad.setOnClickListener{
            val intent = Intent(this, Activdades::class.java)
            startActivity(intent)
        }

        val btnstats: Button = findViewById(R.id.btnStats)
        btnstats.setOnClickListener{
            val intent = Intent(this, estadisticas::class.java)
            startActivity(intent)
        }

        val btnvinculo: Button = findViewById(R.id.btnVinculo)
        btnvinculo.setOnClickListener{
            val intent = Intent(this, vinculo::class.java)
            startActivity(intent)
        }

        val btnrecp: Button = findViewById(R.id.btnReco)
        btnrecp.setOnClickListener{
            val intent = Intent(this, recomendacioness::class.java)
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



    }
}