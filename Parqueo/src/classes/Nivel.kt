package main.classes

class Nivel (
        val id: Int,
        val name: String,
        val color: String,
        val structureFileName: String,
        val mapaNivel: MutableList<MutableList<String>>,
        val placas: MutableList<String> = mutableListOf(),
        var full: Boolean = false
) {
    fun isFull(): Boolean {
        //TODO
        return false
    }

    fun addVehiculo(placa: String, nivel: Int, posicion: String) {
        //TODO
    }

    override fun toString(): String {
        var nivelString = """
            Nivel ${id}: ${name}
                Color: ${color}
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