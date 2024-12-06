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

        // Video 1
        val video1 = findViewById<VideoView>(R.id.video1)
        val uri1: Uri = Uri.parse("android.resource://" + packageName + "/raw/video1")
        video1.setVideoURI(uri1)
        video1.requestFocus()

        val btnPlay1 = findViewById<ImageButton>(R.id.btnPlay1)
        val btnPause1 = findViewById<ImageButton>(R.id.btnPause1)

        btnPlay1.setOnClickListener {
            video1.start()
        }

        btnPause1.setOnClickListener {
            video1.pause()
        }

        // Video 2
        val video2 = findViewById<VideoView>(R.id.video2)
        val uri2: Uri = Uri.parse("android.resource://" + packageName + "/raw/video2")
        video2.setVideoURI(uri2)
        video2.requestFocus()

        val btnPlay2 = findViewById<ImageButton>(R.id.btnPlay2)
        val btnPause2 = findViewById<ImageButton>(R.id.btnPause2)

        btnPlay2.setOnClickListener {
            video2.start()
        }

        btnPause2.setOnClickListener {
            video2.pause()
        }

        // Video 3
        val video3 = findViewById<VideoView>(R.id.video3)
        val uri3: Uri = Uri.parse("android.resource://" + packageName + "/raw/video3")
        video3.setVideoURI(uri3)
        video3.requestFocus()

        val btnPlay3 = findViewById<ImageButton>(R.id.btnPlay3)
        val btnPause3 = findViewById<ImageButton>(R.id.btnPause3)

        btnPlay3.setOnClickListener {
            video3.start()
        }

        btnPause3.setOnClickListener {
            video3.pause()
        }





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