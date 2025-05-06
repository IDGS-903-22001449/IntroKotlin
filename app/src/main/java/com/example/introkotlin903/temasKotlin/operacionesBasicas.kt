package com.example.introkotlin903.temasKotlin

fun main(){

    do {
        println("---Operaciones basicas---")
        println("1-. Suma")
        println("2-. Resta")
        println("3-. Multiplicacion")
        println("4-. Division")
        println("5-. Salir")
        println("--Selecciona una opcion")
        var opcion = readln().toInt()

        if (opcion == 1){
            println("Ingresa el primer numero")
            var numero1 = readln().toDouble()
            println("Ingresa el segundo numero")
            var numero2 = readln().toDouble()
            var resultado = numero1 + numero2
            println("El resultado de la suma es $resultado")
        }else if (opcion == 2){
            println("Ingresa el primer numero")
            var numero1 = readln().toDouble()
            println("Ingresa el segundo numero")
            var numero2 = readln().toDouble()
            var resultado = numero1 - numero2
            println("El resultado de la resta es $resultado")
            println("Ingresa el primer numero")
        }else if (opcion == 3){
            var numero1 = readln().toDouble()
            println("Ingresa el segundo numero")
            var numero2 = readln().toDouble()
            var resultado = numero1 * numero2
            println("El resultado de la multiplicacion es $resultado")
        }else if (opcion == 4){
            var numero1 = readln().toDouble()
            println("Ingresa el segundo numero")
            var numero2 = readln().toDouble()
            var resultado = numero1 / numero2
            println("El resultado de la division es $resultado")
        }
    }while (opcion < 5)
}