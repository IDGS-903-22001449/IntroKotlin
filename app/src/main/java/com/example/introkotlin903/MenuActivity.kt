package com.example.introkotlin903

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin903.practica1.saludoActivity
import com.example.introkotlin903.practica2.OperasActivity
import com.example.introkotlin903.practica3.Ejemplo3Activity
import com.example.introkotlin903.practica4.archivosActivity
import com.example.introkotlin903.practicaCinepolis.CinepolisActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnSaludo = findViewById<Button>(R.id.btn1)
        val btnCalc = findViewById<Button>(R.id.btn2)
        val btnCinepolis = findViewById<Button>(R.id.btn3)
        val btnEjemplo3 = findViewById<Button>(R.id.btn4)
        val btnEjemplo5 = findViewById<Button>(R.id.btn5)

        btnSaludo.setOnClickListener {navigateToSaludo()}
        btnCalc.setOnClickListener {navigateToCalc()}
        btnCinepolis.setOnClickListener {navigateToCinepolis()}
        btnEjemplo3.setOnClickListener {navigateToEjemplo3()}
        btnEjemplo5.setOnClickListener {navigateToArchivos()}

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navigateToSaludo(){
        val intent = Intent(this, saludoActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToCalc(){
        val intent2 = Intent(this, OperasActivity::class.java)
        startActivity(intent2)
    }
    private fun navigateToCinepolis(){
        val intent3 = Intent(this, CinepolisActivity::class.java)
        startActivity(intent3)
    }
    private fun navigateToEjemplo3(){
        val intent4 = Intent(this, Ejemplo3Activity::class.java)
        startActivity(intent4)
    }
    private fun navigateToArchivos(){
        val intent5 = Intent(this, archivosActivity::class.java)
        startActivity(intent5)
    }
}