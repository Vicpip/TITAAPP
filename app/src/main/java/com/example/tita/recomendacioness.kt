package com.example.tita

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class recomendacioness : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recomendacioness)

        val video = findViewById<VideoView>(R.id.video1)
        val uri: Uri = Uri.parse(
            "android.resource://" + packageName + "/raw/video1"
        )
        video.setVideoURI(uri)
        video.requestFocus()
        video.resume()
        video.start()

        val video2 = findViewById<VideoView>(R.id.video2)
        val uri2: Uri = Uri.parse(
            "android.resource://" + packageName + "/raw/video2"
        )
        video2.setVideoURI(uri2)
        video2.requestFocus()
        video2.resume()
        video2.start()

        val video3 = findViewById<VideoView>(R.id.video3)
        val uri3: Uri = Uri.parse(
            "android.resource://" + packageName + "/raw/video3"
        )
        video3.setVideoURI(uri2)
        video3.requestFocus()
        video3.resume()
        video3.start()





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnhome: ImageButton = findViewById(R.id.btnHome)
        btnhome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
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
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btnback: ImageButton = findViewById(R.id.btnBack)
        btnback.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}