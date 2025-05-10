package com.example.introkotlin903.temasKotlin

fun main(){
    /*
    Range -> range es un rango de valores que se pueden recorrer
    1..5 -> Rango de valores del 1 al 5: la salida seria = 1,2,3,4,5
    1..<4=> Rango de valores del 1 al 3: la salida seria = 1,2,3
    4 downTo 1 => Rango de valores del 4 al 1: la salida seria = 4,3,2,1
    1..5 step 2 -> Rango de valores del 1 al 5 de 2 en 2: la salida seria = 1,3,5 (en el ejemplo va de 2 en 2)
    'a'..'z'-> Rango de valores del a al z: la salida seria = a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z
     */

    for(num in 1..5) {
        println(num)
    }

    val frutas = listOf("Manzana","Pera","Frambuesa", "Durazno")
    for(fruta in frutas) {
        println(fruta)
    }

    val n=10
    var d=0
    while(d<n){
        println(d)
            d++
        }


}