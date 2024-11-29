package com.example.tita

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pagar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pagar)

        // Obtener el WebView desde el layout
        val webView: WebView = findViewById(R.id.webView)

        // Configurar WebView
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true // Habilitar JavaScript

        // Establecer un WebViewClient para que los enlaces se abran en el WebView y no en un navegador externo
        webView.webViewClient = WebViewClient()

        // Cargar la URL
        webView.loadUrl("https://aplicaciones.sacmex.cdmx.gob.mx/fut/")

        // Manejo de los márgenes y el sistema de barras de estado y navegación
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
