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
                            println("Crear un nuevo Nivel:")
                            println("Ingrese el numero del Nivel (id): ")
                            val id = readLine()!!
                            println("Ingrese el nombre del Nivel: ")
                            val name = readLine()!!
                            println("Ingrese el color representativo del Nivel: ")
                            val color = readLine()!!
                            println("Ingrese el nombre de archivo de estructura del Nivel: ")
                            val structureFileName = readLine()!!
                            println(parqueo.addNewNivel(id, name, color, structureFileName))
                        }
                        "2" -> {
                            //Eliminar Nivel
                            println("Eliminar Nivel:")
                            println("Ingrese el numero del Nivel (id): ")
                            val id = readLine()!!
                            println(parqueo.removeNivel(id))
                        }
                        "3" -> {
                            //Ver Niveles
                            println(parqueo)
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
                            if (!parqueo.isFull()) {
                                println("Ingrese el numero de placa: ")
                                val placa = readLine()!!
                                if (parqueo.placaEnParqueo(placa)) {
                                    println(parqueo.mostrarUbicacionPlaca(placa))
                                } else {
                                    var nivelID: String
                                    do {
                                        println(parqueo.mostrarNivelesDisponibles())
                                        println("Ingrese el nivel al que desea acceder: ")
                                        nivelID = readLine()!!
                                    } while (!parqueo.nivelDisponible(nivelID))
                                    var posicion: String
                                    do {
                                        println(parqueo.getNivel(nivelID))
                                        println("Ingrese el parqueo deseado: ")
                                        posicion = readLine()!!
                                    } while (!parqueo.addVehiculoToNivel(placa, nivelID, posicion))
                                }
                            } else {
                                println("Lo sentimos, ya no hay espacio disponible.")
                            }
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