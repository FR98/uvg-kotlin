//Francisco Rosal 18676

package main
import main.classes.*

fun main(args: Array<String>) {
    var continuar = true
    val listaDeListadeTareas: ArrayList<ListaDeTareas> = ArrayList()

    do{
        println("To Do:")

        if (listaDeListadeTareas.count() == 0) {
            println(menu1())
            var opcion = readLine()!!
            when (opcion) {
                "1" -> {
                    println("Crear Lista")
                    listaDeListadeTareas.add()
                }
                "2" -> continuar = false
                else -> println("Opcion Invalida")
            }
        } else {
            println(menu2())
            var opcion = readLine()!!
            when (opcion) {
                "1" -> {
                    println("Crear Lista")
                }
                "2" -> {
                    println("Ver Listas")
                }
                "3" -> {
                    println("Seleccionar Lista")
                }
                "4" -> continuar = false
                else -> println("Opcion Invalida")
            }
        }

    } while (continuar)
}