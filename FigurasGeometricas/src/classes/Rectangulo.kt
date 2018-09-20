package classes

class Rectangulo {
    var base: Int
    var altura: Int

    constructor(_base: Int = 0, _altura: Int = 0) {
        base = _base
        altura = _altura
    }

    fun dibujar() {
        //TODO
    }

    fun describir() {
        println("Ingrese la base del cuadrado: ")
        var baseInput = readLine()!!
        base = baseInput.toInt()
    }
}