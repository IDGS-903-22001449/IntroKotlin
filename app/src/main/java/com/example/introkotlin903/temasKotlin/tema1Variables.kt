package com.example.introkotlin903.temasKotlin

fun main(){
    // de clarecion de variables
    val nombre = "Carlos"
    val edad = 25

    println("Hola, mi nombre es $nombre y mi edad es $edad")

    // imprimir en cosola println imprime y hace un salto de linea, pero tambien existe print y solo imprime en una linea
    println("Hola mundo !!")

    var numero1 = 10
    var numero2 = 5
    var suma = numero1 + numero2

    // la variable de tipo var permite que puedas asignar un nuevo valor en la variable, mientras que val es un valor que no se puede cambiar
    numero1 = 30
    println("la suma de $numero1 y $numero2 es $suma")
    print("_______________________________________________________________________________________________________" +
            "")

    /*
    val nombre = "Veronica"
    val edad = 22
    println("Hola, mi nombre es $nombre y mi edad es $edad")
     */
}