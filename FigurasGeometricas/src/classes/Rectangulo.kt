package classes

import interfaces.Describible
import interfaces.Dibujable

class Rectangulo: Describible, Dibujable {
    //Atributos
    override var base: Int
    override var altura: Int

    //Constructor
    constructor(_base: Int = 0, _altura: Int = 0) {
        base = _base
        altura = _altura
    }

    //Metodo para dibujar
    override fun dibujar() {
        for (i in 1..altura) {
            for (j in 1..base) {
                print("* ")
            }
            print("\n")
        }
    }

    //Metodo para describir la figura
    override fun describir() {
        //Se piden datos y se asignan
        println("Ingrese la base del rectangulo: ")
        val baseInput = readLine()!!
        base = baseInput.toInt()
        println("Ingrese la altura del rectangulo: ")
        val alturaInput = readLine()!!
        altura = alturaInput.toInt()
    }
}