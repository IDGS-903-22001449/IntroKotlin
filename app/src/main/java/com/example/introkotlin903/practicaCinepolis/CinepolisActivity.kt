package com.example.introkotlin903.practicaCinepolis

import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
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

class CinepolisActivity : AppCompatActivity() {
    private lateinit var edt1: EditText
    private lateinit var edtCantCompradores: EditText
    private lateinit var edtCantBoletos : EditText
    private lateinit var rdSi : RadioButton
    private lateinit var rdNo : RadioButton
    private lateinit var tvTotal : TextView
    private lateinit var btnCalcular : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)

        edt1 = findViewById(R.id.edt1)
        edtCantCompradores = findViewById(R.id.edtCantCompradores)
        edtCantBoletos = findViewById(R.id.edtCantBoletos)
        rdSi = findViewById(R.id.rdSi)
        rdNo = findViewById(R.id.rdNo)
        tvTotal = findViewById(R.id.tvTotal)
        btnCalcular = findViewById(R.id.btnCalcular)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnCalcular.setOnClickListener {
            val precioBoleta = 12.0
            val nombre = edt1.text.toString()
            val cantCompradores = edtCantCompradores.text.toString().toDoubleOrNull() ?: 0.0
            val cantBoletos = edtCantBoletos.text.toString().toDoubleOrNull() ?: 0.0

            if (cantBoletos > (cantCompradores * 7)){
                Toast.makeText(this, "Cada comprador no puede comprar más de 7 boletos...", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val descCantBoletos = when {
                cantBoletos > 5 -> 0.15
                cantBoletos.toInt() in 3..5 -> 0.10
                else -> 0.0
            }

            var total = cantBoletos * precioBoleta
            total -= total * descCantBoletos

            var totalPago = total
            if (rdSi.isChecked) {
                totalPago -= total * 0.10
            }

            tvTotal.text = "$nombre debe pagar:  $${"%.2f".format(totalPago)}"

        }
    }

}