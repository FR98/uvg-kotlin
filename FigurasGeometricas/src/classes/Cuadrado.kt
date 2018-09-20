package classes

import interfaces.Describible
import interfaces.Dibujable

class Cuadrado: Describible, Dibujable {
    override var base: Int
    override var altura: Int

    constructor(_base: Int = 0) {
        base = _base
        altura = base
    }

    override fun dibujar() {
        for (i in 1..altura) {
            for (j in 1..base) {
                print("* ")
            }
            print("\n")
        }
    }

    override fun describir() {
        println("Ingrese la base del cuadrado: ")
        var baseInput = readLine()!!
        base = baseInput.toInt()
        altura = base
    }

}