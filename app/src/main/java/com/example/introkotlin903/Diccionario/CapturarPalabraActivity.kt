package com.example.introkotlin903.Diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin903.R

class CapturarPalabraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capturar_palabra)

        val btnGuardarPalabra = findViewById<Button>(R.id.btnGuardarPalabra)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)
        val edtEn = findViewById<EditText>(R.id.edtEn)
        val edtEs = findViewById<EditText>(R.id.edtEs)


        btnGuardarPalabra.setOnClickListener {
            val textoEs = edtEs.text.toString()
            if (textoEs.isBlank()) {
                Toast.makeText(this, "Ingrese una palabra en español", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val textoEn = edtEn.text.toString()
            if (textoEn.isBlank()) {
                Toast.makeText(this, "Ingrese la palabra en inglés", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                openFileOutput("diccionario.txt", MODE_APPEND).use {
                    it.write("$textoEs : $textoEn\n".toByteArray())
                    Toast.makeText(this, "Palabras guardadas con exio.", Toast.LENGTH_SHORT).show()
                    edtEs.text.clear()
                    edtEn.text.clear()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Error al guardar: ${e.message}", Toast.LENGTH_SHORT).show()
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