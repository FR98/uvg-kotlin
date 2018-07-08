//Francisco Rosal 18676
//07/07/2018

package main
import main.utils.*

fun main(args: Array<String>) {
    println("Hello to your Radio \nName your Radio: ")
    val newName = readLine()!!
    //Se crea el objeto Radio
    val newRadio = Radio(
            name = newName
    )

    do {
        var salir = false
        println(newRadio)
        println()
        println(newRadio.menu())
        val action = readLine()!!

        if (newRadio.isTurnOn) {
            when (action) {
                "1" -> newRadio.turnOff()
                "2" -> newRadio.changeFrequency()
                "3", "4" -> {
                    var strJumps: String?
                    var jumps: Double
                    var okJumps  = false
                    do {
                        println("De cuanto en cuanto? ")
                        strJumps = readLine()
                        if (strJumps != null) {
                            try {
                                jumps = strJumps.toDouble()
                                when (action) {
                                    "3" -> newRadio.upperStation(jumps)
                                    "4" -> newRadio.lowerStation(jumps)
                                }
                                okJumps = true
                            } catch (error: NumberFormatException) {
                                println("Opcion invalida, vuelve a intentarlo")
                                okJumps = false
                            }
                        }
                    } while (!okJumps)

                }
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