package main

import main.utils.*

fun main(args: Array<String>) {
    println("Hello to your Radio \nName your Radio: ")
    val newName = readLine()!!

    val newRadio = Radio(
            name = newName
    )

    do {
        var salir: Boolean = false
        println(newRadio)
        println()
        println(newRadio.menu())
        var action = readLine()!!

        if (newRadio.isTurnOn) {
            when (action) {
                "1" -> newRadio.turnOff()
                "2" -> newRadio.changeFrequency()
                //"3" -> newRadio.upperStation()
                //"4" -> newRadio.lowerStation()
                "5" -> newRadio.moreVolume()
                "6" -> newRadio.lessVolume()
                "7" -> {
                    println("Hasta la proxima")
                    salir = true
                }
                else -> println("Opcion incorrecta")
            }
        } else {
            when (action) {
                "1" -> newRadio.turnOn()
                "2" -> {
                    println("Hasta la proxima")
                    salir = true
                }
                else -> println("Opcion incorrecta")
            }
        }

    } while (salir)

}