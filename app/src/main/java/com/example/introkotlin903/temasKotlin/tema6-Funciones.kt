package com.example.introkotlin903.temasKotlin

fun sum (x:Int, y:Int): Int{
    return x+y
}

fun sum2 (x: Int, y: Int) = x + y

fun main(){
    saludo()
    println("---------------------------------------------------------------------------------------------------" +
            "")
    println(sum(2,5))
    println(sum2(2,3))
}

fun saludo(){
    println("Hola mundo")
}