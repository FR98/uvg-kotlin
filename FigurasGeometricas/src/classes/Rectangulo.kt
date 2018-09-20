package classes

import interfaces.Describible
import interfaces.Dibujable

class Rectangulo: Describible, Dibujable {
    override var base: Int
    override var altura: Int

    constructor(_base: Int = 0, _altura: Int = 0) {
        base = _base
        altura = _altura
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
        println("Ingrese la base del rectangulo: ")
        var baseInput = readLine()!!
        base = baseInput.toInt()
        println("Ingrese la altura del rectangulo: ")
        var alturaInput = readLine()!!
        altura = alturaInput.toInt()
    }
}