package com.example.introkotlin903.practica4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin903.R
import java.io.FileNotFoundException
import android.widget.Toast

class archivosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_archivos)

        val btnGuardar = findViewById<Button>(R.id.saveButton)
        val btnLeer = findViewById<Button>(R.id.readButton)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        val outPutText = findViewById<TextView>(R.id.outputText)
        val inputText = findViewById<EditText>(R.id.inputText)

        btnGuardar.setOnClickListener {
            val texto = inputText.text.toString()
            if (texto.isBlank()) {
                Toast.makeText(this, "Ingrese texto para guardar", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                openFileOutput("datos.txt", MODE_APPEND).use {
                    it.write("$texto\n".toByteArray())
                    Toast.makeText(this, "Texto guardado", Toast.LENGTH_SHORT).show()
                    inputText.text.clear() // Limpiar el campo después de guardar
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Error al guardar: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        btnLeer.setOnClickListener {
            try {
                val contenido = openFileInput("datos.txt").bufferedReader().use { reader ->
                    val sb = StringBuilder()
                    var line: String?
                    while (reader.readLine().also { line = it } != null) {
                        sb.append(line).append("\n")
                    }
                    sb.toString()
                }
                outPutText.text = contenido
            } catch (e: FileNotFoundException) {
                outPutText.text = "Archivo no encontrado"
                Toast.makeText(this, "Archivo no encontrado", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
                outPutText.text = "Error al leer archivo"
                Toast.makeText(this, "Error al leer: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        btnBorrar.setOnClickListener {
            try {
                deleteFile("datos.txt")
                outPutText.text = ""
                Toast.makeText(this, "Archivo borrado", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Error al borrar: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}