package classes

class Cuadrado {
    var base: Int
    var altura: Int

    constructor(_base: Int = 0) {
        base = _base
        altura = base
    }

    fun dibujar() {
        for (i in 1..base) {
            for (i in 1..base) {
                print("*")
            }
            print("\n")
        }
    }

    fun describir() {
        println("Ingrese la base del cuadrado: ")
        var baseInput = readLine()!!
        base = baseInput.toInt()
        altura = base
    }

}