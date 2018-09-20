import classes.*
import interfaces.Describible
import interfaces.Dibujable

fun main(args: Array<String>) {

    var continuar = true

    do {
        println(menu1())
        val menu1Opcion = readLine()!!

        when(menu1Opcion) {
            "1" -> {
                var continuar2 = false

                do {
                    println(menu2())
                    var menu2Opcion = readLine()!!

                    when(menu2Opcion) {
                        "1" -> {
                            var cuadrado = Cuadrado()
                            describirPrin(cuadrado)
                            dibujarPrin(cuadrado)
                        }
                        "2" -> {
                            var rectangulo = Rectangulo()
                            describirPrin(rectangulo)
                            dibujarPrin(rectangulo)
                        }
                        "3" -> {
                            var triangulo = Triangulo()
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

fun describirPrin(describible: Describible) {
    describible.describir()
}

fun dibujarPrin(dibujo: Dibujable) {
    dibujo.dibujar()
}