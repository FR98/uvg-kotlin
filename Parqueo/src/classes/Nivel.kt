package main.classes

class Nivel (
        val id: Int,
        val name: String,
        val color: String,
        private val structureFileName: String,
        private val mapaNivel: MutableList<MutableList<String>>,
        val placas: MutableList<String> = mutableListOf()
) {
    fun isFull(): Boolean {
        for (l in mapaNivel) {
            for (e in l) {
                if (e == "*") {
                    continue
                } else if (e == " ") {
                    continue
                } else if (e == "@"){
                    continue
                } else {
                    return false
                }
            }
        }
        return true
    }

    fun addVehiculo(placa: String, posicion: String): Boolean {
        placas.add(placa)
        for (l in mapaNivel) {
            for (e in l.indices) {
                if (posicion != "*" && posicion != " ") {
                    if (l[e] == posicion) {
                        l[e] = "@"
                        return true
                    }
                }
            }
        }
        return false
    }

    override fun toString(): String {
        var nivelString = """
            Nivel $id: $name
                Color: $color
                Ubicacion de archivo: $structureFileName
                Mapa:

        """.trimIndent()

        for (line in mapaNivel) {
            for (element in line) {
                nivelString += element
            }
            nivelString += "\n"
        }

        return nivelString
    }
}