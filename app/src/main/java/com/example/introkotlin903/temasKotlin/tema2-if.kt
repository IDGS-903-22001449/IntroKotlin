package com.example.introkotlin903.temasKotlin

fun main (){
    println("Ingresa el sueldo del empleado")
    // readln hace una lectura de un dato desde el teclado, lo que escribe el usuario y despues el tipo de dato que esta ingresando
    val sueldo = readln().toDouble()

    if(sueldo > 3000){
        println("Debe pagar impuestos")
    }else{
        println("No debe pagar impuestos")
    }
}