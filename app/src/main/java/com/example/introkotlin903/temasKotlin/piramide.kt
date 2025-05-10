package com.example.introkotlin903.temasKotlin

/*
practica3 = imprimir una piramide de * segun el numero dado por el usuario
n = 5
*
**
***
****
*****
cuando se capture un 0 terminar el programa, utilizando puro do-while

practica 4: formula general
 */


fun main() {
    do {
        println("Ingresa un numero para la piramide")
        val numA = readln().toInt()
        if (numA > 0) {
            var fila = 1
            do {
                var columna = 1
                do {
                    print("*")
                    columna++
                } while (columna <= fila)
                println()
                fila++
            } while (fila <= numA)
        }
    } while (numA != 0)
}

//        for (fila in 1..numA) {
//            for (asterisco in 1..fila) {
//                print("*")
//            }
//            println()
//        }