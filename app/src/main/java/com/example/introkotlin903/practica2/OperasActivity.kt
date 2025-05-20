package com.example.introkotlin903.practica2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin903.R

class OperasActivity : AppCompatActivity() {
    // lateinit es para inicializar mas tarde, hace que la variable no sea nula y que no de error si no se inicializa antes de usarla
    private lateinit var edt1: EditText
    private lateinit var edt2: EditText
    private lateinit var btn1: Button
    private lateinit var tv1: TextView
    private lateinit var r1: RadioButton
    private lateinit var r2: RadioButton
    private lateinit var r3: RadioButton
    private lateinit var r4: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operas)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        tv1 = findViewById(R.id.tv1)
        r1 = findViewById(R.id.r1)
        r2 = findViewById(R.id.r2)
        r3 = findViewById(R.id.r3)
        r4 = findViewById(R.id.r4)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: android.view.View){
        if (r1.isChecked){
            calcSuma(view)
        } else if (r2.isChecked){
            calcResta(view)
        } else if (r3.isChecked){
            calcMult(view)
        } else if (r4.isChecked){
            calcDividir(view)
        }
    }

    fun calcSuma(view: android.view.View){
        val num1 = edt1.text.toString().toDouble()
        val num2 = edt2.text.toString().toDouble()
        val suma = num1 + num2
        val result1 = "Resultado $suma"
        tv1.text = result1
    }

    fun calcResta(view: android.view.View){
        val num1 = edt1.text.toString().toDouble()
        val num2 = edt2.text.toString().toDouble()
        val resta = num1 - num2
        val result1 = "Resultado $resta"
        tv1.text = result1
    }

    fun calcMult(view: android.view.View){
        val num1 = edt1.text.toString().toDouble()
        val num2 = edt2.text.toString().toDouble()
        val mult = num1 * num2
        val result1 = "Resultado $mult"
        tv1.text = result1
    }

    fun calcDividir(view: android.view.View){
        val num1 = edt1.text.toString().toDouble()
        val num2 = edt2.text.toString().toDouble()
        val div = num1 / num2
        val result1 = "Resultado $div"
        tv1.text = result1
    }
}