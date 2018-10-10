package People

import behavior.Walker

open class Persona: Walker {
    var name: String

    var age: Int
        set(value) {
            field = value
            isAdult = age >= 18
        }

    var isAdult: Boolean
        private set

    constructor(_nombre: String, _edad: Int) {
        name = _nombre
        age = _edad
        isAdult = age >= 18
        println("YeyC")
    }

    override var steps = 0

    init {
        println("Yey")
    }

    override fun walk() {
        println("Ay")
        steps += 1
    }

    override fun toString(): String {
        return """
            Nombre: $name
            Edad: $age
            Adulto: $isAdult
        """.trimIndent()
    }
}