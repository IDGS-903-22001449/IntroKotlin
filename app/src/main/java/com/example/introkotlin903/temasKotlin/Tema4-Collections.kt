package com.example.introkotlin903.temasKotlin

fun main(){
    /*
    List            - listas simples, muestran los datos en orden (val) y admite valores dupicados
    MutableList     - admite valores duplicados
    Set             - no muestran datos repetidos, solo unicos y
    MutableSet      - son como diccionarios con datos que hacen referencia a su variable y su valor
    Map             -
    MutableMap      -
     */
    var lista = listOf<String>("Lunes","Martes", "Miercoles")
    println(lista)
    println(lista.size)
    println(lista.count())
    println(lista.get(0))
    println(lista[1])
    println(lista.indexOf("Miercoles"))
    println(lista.first())
    println(lista.last())


    var listMutable = mutableListOf<String>("Lunes","Martes", "Miercoles")
    println(listMutable)
    listMutable.add("Jueves")
    println(listMutable)
    listMutable.removeAt(0)
    println(listMutable)
    listMutable.add(0, "Domingo")
    println(listMutable)
    listMutable.remove("Miercoles")
}