package main

import main.utils.*

fun main(args: Array<String>) {
    println("Hello to your Radio \nName your Radio: ")
    val newName = readLine()!!

    val newRadio = Radio(
            name = newName
    )

    println(newRadio)


}