package Animales

import behavior.Walker

class Perro: Walker {
    var nombre: String
    var raza: String
    override var steps = 0

    constructor(_nombre: String, _raza: String) {
        nombre = _nombre
        raza = _raza
    }

    fun ladrar() {
        println("Woof")
    }

    override fun walk() {
        steps += 2
        ladrar()
    }
}