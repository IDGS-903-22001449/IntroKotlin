package com.example.introkotlin903.temasKotlin

import kotlin.math.sqrt

fun main() {
    println("Ingrese el valor de a")
    val a = readln().toDouble()
    println("Ingresa el valor de b")
    val b = readln().toDouble()
    println("Ingresa el valor de c")
    val c = readln().toDouble()

    val discriminante = b * b - (4 * a * c)

    when {
        discriminante > 0 -> {
            val x1 = (-b + sqrt(discriminante)) / (2 * a)
            val x2 = (-b - sqrt(discriminante)) / (2 * a)
            println("Las soluciones son: x1 = $x1, x2 = $x2")
        }
        discriminante == 0.0 -> {
            val x = -b / (2 * a)
            println("La solución única es: x = $x")
        }
        else -> {
            val parteReal = -b / (2 * a)
            val parteImaginaria = sqrt(-discriminante) / (2 * a)
            println("Las soluciones son complejas:")
            println("x1 = ${parteReal} + ${parteImaginaria}i")
            println("x2 = ${parteReal} - ${parteImaginaria}i")
        }
    }
}