package com.example.introkotlin903.practica1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin903.R

class saludoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_saludo)
        
        // Configurar insets para el borde a borde
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        // Obtener referencias a las vistas
        val edtName = findViewById<androidx.appcompat.widget.AppCompatEditText>(R.id.edtName)
        val button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.button)
        
        // Implementar el click listener del botón
        button.setOnClickListener {
            val nombre = edtName.text.toString()
            if (nombre.isNotEmpty()) {
                Toast.makeText(this, "¡Hola $nombre!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor, escribe tu nombre", Toast.LENGTH_SHORT).show()
            }
        }
    }
}