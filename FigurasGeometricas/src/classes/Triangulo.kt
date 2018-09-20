package classes

import interfaces.Describible
import interfaces.Dibujable

class Triangulo: Describible, Dibujable {
    //Atributos
    override var base: Int
    override var altura: Int

    //Constructor
    constructor(_altura: Int = 0) {
        altura = _altura
        base = altura
    }

    //Metodo para dibujar
    override fun dibujar() {
        var resultado = ""
        var espacio = 1
        for (i in 1..altura) {
            //resultado += " " * (altura - i) + " *" * (i + 1) + "\n"
            for (j in 1..altura-espacio) {
                resultado += " "
            }
            for (h in 1..espacio) {
                resultado += " *"
            }
            resultado += "\n"
            espacio += 1
        }

        println(resultado)
    }

    //Metodo para describir la figura
    override fun describir() {
        //Se piden datos y se asignan
        println("Ingrese la base del triangulo: ")
        val baseInput = readLine()!!
        base = baseInput.toInt()
        altura = base
    }
}