import classes.*
import interfaces.Describible
import interfaces.Dibujable

fun main(args: Array<String>) {

    var continuar = true

    do {
        //Se muestra menu y se pide opcion
        println(menu1())
        val menu1Opcion = readLine()!!

        when(menu1Opcion) {
            "1" -> {
                var continuar2 = false

                do {
                    //Se muestra menu y se pide opcion
                    println(menu2())
                    val menu2Opcion = readLine()!!

                    when(menu2Opcion) {
                        "1" -> {
                            //Se instancia un cuadrado, se piden datos y se dibuja
                            val cuadrado = Cuadrado()
                            describirPrin(cuadrado)
                            dibujarPrin(cuadrado)
                        }
                        "2" -> {
                            //Se instancia un rectangulo, se piden datos y se dibuja
                            val rectangulo = Rectangulo()
                            describirPrin(rectangulo)
                            dibujarPrin(rectangulo)
                        }
                        "3" -> {
                            //Se instancia un triangulo, se piden datos y se dibuja
                            val triangulo = Triangulo()
                            describirPrin(triangulo)
                            dibujarPrin((triangulo))
                        }
                        "4" -> continuar2 = false
                        else -> {
                            println("Opcion invalida")
                        }
                    }
                } while(continuar2)
            }
            "2" -> {
                continuar = false
            }
            else -> {
                println("Opcion invalida")
            }
        }
    } while(continuar)
}

//Interfaz para pedir datos
fun describirPrin(describible: Describible) {
    describible.describir()
}

//Interfaz para dibujar
fun dibujarPrin(dibujo: Dibujable) {
    dibujo.dibujar()
}