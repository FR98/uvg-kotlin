package classes

import interfaces.Describible
import interfaces.Dibujable

class Triangulo: Describible, Dibujable {
    override var base: Int
    override var altura: Int

    constructor(_altura: Int = 0) {
        altura = _altura
        base = altura
    }

    override fun dibujar() {
        var resultado = ""
        for (i in 1..altura) {
            //resultado += " " * (altura - i) + " *" * (i + 1) + "\n"

        }
    }

    override fun describir() {
        println("Ingrese la base del triangulo: ")
        var baseInput = readLine()!!
        base = baseInput.toInt()
        altura = base
    }
}