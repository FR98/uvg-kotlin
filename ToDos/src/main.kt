//Francisco Rosal 18676

package main
import main.classes.*

fun main(args: Array<String>) {
    var continuar = true
    val listaDeListadeTareas: ArrayList<ListaDeTareas> = ArrayList()

    do{
        println("\nTo Do:")

        if (listaDeListadeTareas.count() == 0) {
            println(menu1())
            println("Ingrese su eleccion: ")
            var opcion = readLine()!!
            when (opcion) {
                "1" -> {
                    println("Crear Lista:")
                    println("Ingrese el nombre de la nueva Lista: ")
                    var input = readLine()!!
                    val nuevaLista = ListaDeTareas(
                            name = input
                    )
                    listaDeListadeTareas.add(nuevaLista)
                }
                "2" -> continuar = false
                else -> println("Opcion Invalida")
            }
        } else {
            println(menu2())
            println("Ingrese su eleccion: ")
            var opcion = readLine()!!
            when (opcion) {
                "1" -> {
                    println("Crear Lista:")
                    println("Ingrese el nombre de la nueva Lista: ")
                    var input = readLine()!!
                    val nuevaLista = ListaDeTareas(
                            name = input
                    )
                    listaDeListadeTareas.add(nuevaLista)
                }
                "2" -> {
                    println("Ver Listas:")
                    var contador = 0
                    for (i: ListaDeTareas in listaDeListadeTareas){
                        contador += 1
                        println("$contador $i.name")
                    }
                }
                "3" -> {
                    println("Seleccionar Lista:")
                    var contador = 0
                    for (i: ListaDeTareas in listaDeListadeTareas){
                        contador += 1
                        println("$contador $i.name")
                    }
                    println("Ingrese el numero de la Lista: ")
                    var input = readLine()!!
                    var listaSelec = input.toInt()

                    if (listaSelec < listaDeListadeTareas.count() && listaSelec > 0){
                        var lista = listaDeListadeTareas.get(listaSelec)
                        var continuar2 = true
                        do {
                            println(menu3(lista))
                            println("Ingrese su eleccion: ")
                            var opcion = readLine()!!
                            when (opcion) {
                                "1" -> continuar2 = false
                                "2" ->
                            }
                        } while (continuar2)
                    }

                }
                "4" -> continuar = false
                else -> println("Opcion Invalida")
            }
        }

    } while (continuar)
}