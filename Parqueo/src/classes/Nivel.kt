package main.classes

class Nivel (
        private val id: Int,
        private val name: String,
        private val color: String,
        private val structureFileName: String,
        private val ancho: Int,
        private val largo: Int,
        private val listaEstacionamiento: MutableList<Estacionamiento>,
        private val listaParedes: MutableList<Pared>,
        private val listaTransitables: MutableList<EspacioTransitable>
) {
    fun getId(): Int {
        return id
    }

    fun getName(): String {
        return name
    }

    fun getColor(): String {
        return color
    }

    fun isFull(): Boolean {
        for (estacionamiento in listaEstacionamiento) {
            if (!estacionamiento.getIsOcupado()) {
                return false
            }
        }
        return true
    }

    fun addVehiculo(placa: String, posicion: String): Boolean {
        for (estacionamiento in listaEstacionamiento) {
            if (estacionamiento.getId() == posicion) {
                estacionamiento.ocupar(placa)
                return true
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

        for (line in mapa) {
            for (element in line) {
                nivelString += element
            }
            nivelString += "\n"
        }

        return nivelString
    }
}