//Francisco Rosal

package main

import main.classes.Parqueo
import main.utilidades.*


fun main(args: Array<String>) {
    println("BIENVENIDO")
    var continuar = true
    var opcion: String
    val parqueo = Parqueo(1)

    do {
        println(menu1())
        opcion = readLine()!!
        when (opcion) {
            "1" -> {
                //Menu Admin
                do {
                    var continuar2 = true
                    println(menu2())
                    opcion = readLine()!!
                    when (opcion) {
                        "1" -> {
                            //Crear Nivel
                        }
                        "2" -> {
                            //Eliminar Nivel
                        }
                        "3" -> {
                            //Ver Niveles
                        }
                        "4" -> {
                            continuar2 = false
                        }
                        else -> println("Opcion Invalida")
                    }
                } while (continuar2)
            }
            "2" -> {
                //Menu Conductor
                do {
                    var continuar3 = true
                    println(menu3())
                    opcion = readLine()!!
                    when (opcion) {
                        "1" -> {
                            //Ingresar Placa
                        }
                        "2" -> {
                            continuar3 = false
                        }
                        else -> println("Opcion Invalida")
                    }
                } while (continuar3)
            }
            "3" -> {
                continuar = false
            }
            else -> println("Opcion Invalida")
        }

    } while (continuar)
}