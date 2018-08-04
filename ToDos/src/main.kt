//Francisco Rosal 18676

package main
import main.classes.*

fun main(args: Array<String>) {
    var continuar = true
    val listaDeListadeTareas: ArrayList<ListaDeTareas> = ArrayList()
    var opcion: String
    var input: String

    do{
        println("\nTo Do:")

        if (listaDeListadeTareas.count() == 0) {
            println(menu1())
            println("Ingrese su eleccion: ")
            opcion = readLine()!!
            when (opcion) {
                "1" -> {
                    println("Crear Lista:")
                    println("Ingrese el nombre de la nueva Lista: ")
                    input = readLine()!!
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
            opcion = readLine()!!
            when (opcion) {
                "1" -> {
                    println("Crear Lista:")
                    println("Ingrese el nombre de la nueva Lista: ")
                    input = readLine()!!
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
                        println("$contador. $i")
                    }
                }
                "3" -> {
                    println("Seleccionar Lista:")
                    var contador = 0
                    for (i: ListaDeTareas in listaDeListadeTareas){
                        contador += 1
                        println("$contador. ${i.name}")
                    }
                    println("Ingrese el numero de la Lista: ")
                    input = readLine()!!
                    var listaSelec = input.toInt()

                    if ((listaSelec-1) < listaDeListadeTareas.count() && listaSelec > 0){
                        var lista = listaDeListadeTareas.get(listaSelec-1)
                        var continuar2 = true
                        do {
                            println(menu3(lista))
                            println("Ingrese su eleccion: ")
                            opcion = readLine()!!
                            when (opcion) {
                                "1" -> continuar2 = false
                                "2" -> {
                                    println("Ingrese el nombre de la nueva Tarea: ")
                                    input = readLine()!!
                                    val nuevaTarea = Tarea(
                                            name = input
                                    )
                                    lista.addTarea(nuevaTarea)
                                }
                                "3" -> {
                                    println("Completar Tarea:")
                                    contador = 0
                                    for (i: Tarea in lista.tareas){
                                        contador += 1
                                        println("$contador. ${i.name}")
                                    }
                                    println("Ingrese el numero de la Tarea a completar: ")
                                    input = readLine()!!
                                    var tareaSelec = input.toInt()
                                    if ((tareaSelec-1) < lista.tareas.count() && tareaSelec > 0){
                                        var tarea = lista.tareas.get(tareaSelec-1)
                                        tarea.completada = !tarea.completada
                                        println("Tarea completada exitosamente")
                                    }
                                }
                                "4" -> {
                                    println("Tareas de la lista:")
                                    contador = 0
                                    for (i: Tarea in lista.tareas){
                                        contador += 1
                                        println("$contador. ${i.name}")
                                        if (i.completada){
                                            print(" - (Completada)")
                                        }else{
                                            print(" - (Sin completar)")
                                        }
                                        println("\n")

                                    }
                                }
                                "5" -> {
                                    println("Eliminar tarea")
                                    contador = 0
                                    for (i: Tarea in lista.tareas){
                                        contador += 1
                                        println("$contador. ${i.name}")
                                    }
                                    println("Ingrese el numero de la Tarea a eliminar: ")
                                    input = readLine()!!
                                    var tareaSelec = input.toInt()
                                    if (tareaSelec < lista.tareas.count() && tareaSelec > 0){
                                        var tarea = lista.tareas.get(tareaSelec)
                                        lista.tareas.remove(tarea)
                                    }

                                }
                                "6" -> continuar2 = false
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