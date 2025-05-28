package com.example.introkotlin903.Diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin903.R

class BuscarPalabraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar_palabra)

        val btnRegresar = findViewById<Button>(R.id.btnMenu)
        val btnBuscarPalabra = findViewById<Button>(R.id.btnBuscarPalabra)
        val rdEs = findViewById<RadioButton>(R.id.rdEs)
        val rdEn = findViewById<RadioButton>(R.id.rdEn)
        val edtPalabra = findViewById<EditText>(R.id.edtPalabra)
        val outputText = findViewById<TextView>(R.id.outputText)


        btnBuscarPalabra.setOnClickListener {
            val palabraBuscada = edtPalabra.text.toString()
            if (palabraBuscada.isBlank()) {
                Toast.makeText(this, "Ingrese una palabra para buscar en el diccionario ", Toast.LENGTH_SHORT).show()
                outputText.text = "Ingrese una palabra para buscar"
                return@setOnClickListener
            }

            try{
                val diccionario = openFileInput("diccionario.txt")
                val lineas = diccionario.bufferedReader().readLines()
                var resultado: String? = null

                for (linea in lineas){
                    val partes = linea.split(" : ")
                    if (partes.size == 2) {
                        val palabraEs = partes[0].trim()
                        val palabraEn = partes[1].trim()

                        if (rdEs.isChecked && palabraEn.equals(palabraBuscada, ignoreCase = true)){
                            resultado = "Español: $palabraEs, Inglés $palabraEn"
                            break
                        }else if (rdEn.isChecked && palabraEs.equals(palabraBuscada, ignoreCase = true)) {
                            resultado = "Español: $palabraEs, Inglés $palabraEn"
                            break
                        }
                    }
                }

                if (resultado != null) {
                    Toast.makeText(this, resultado, Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Palabra no encontrada", Toast.LENGTH_SHORT).show()
                }

                outputText.text = resultado ?: "Palabra no encontrada"

            }catch (e: Exception){
                e.printStackTrace()
                Toast.makeText(this, "Error al leer archivo: ${e.message}", Toast.LENGTH_SHORT).show()
                outputText.text = "Error al leer archivo: ${e.message}"
            }
        }

        btnRegresar.setOnClickListener {navigateToMenuDic()}

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun navigateToMenuDic() {
        val intentMenuDic = Intent(this, MenuDiccionarioActivity::class.java)
        startActivity(intentMenuDic)
    }
}