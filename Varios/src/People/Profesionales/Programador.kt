package People.Profesionales

import People.Persona

class Programador: Persona {
    var lenguaje: String

    constructor(nombre: String, edad: Int, _lenguaje: String): super(nombre, edad) {
        lenguaje = _lenguaje
    }

    override fun toString(): String {
        return """
            ${super.toString()}
            Lenguaje: $lenguaje
        """.trimIndent()
    }
}