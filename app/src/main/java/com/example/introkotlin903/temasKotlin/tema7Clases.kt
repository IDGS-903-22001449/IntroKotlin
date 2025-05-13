package com.example.introkotlin903.temasKotlin

class usuarios(){
    val materia:String=""
}

class usuarios2(val id:Int, val nombre:String){
    val materia:String=""
    fun hola(){
        println("hola")
    }
}

fun main(){
    val alumno = usuarios()
    val alumno2 = usuarios2(1, "Carlos")

    println(alumno2.id)
    // hace referencia a la variable de la clase
    println(alumno2.nombre)
    alumno2.hola()
}