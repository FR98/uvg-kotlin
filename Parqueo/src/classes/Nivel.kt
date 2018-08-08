package main.classes

class Nivel (
        private val id: Int,
        private val name: String,
        private val color: String,
        private val structureFileName: String,
        private val ancho: Int,
        private val largo: Int,
        private val listaEstacionamientos: MutableList<Estacionamiento>,
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

    fun getEstacionamientoConPlaca(placa: String): Estacionamiento? {
        listaEstacionamientos.forEach {
            if (it.getPlaca() == placa && it.getIsOcupado()) {
                return it
            }
        }
        return null
    }

    fun isFull(): Boolean {
        for (estacionamiento in listaEstacionamientos) {
            if (!estacionamiento.getIsOcupado()) {
                return false
            }
        }
        return true
    }

    fun addVehiculo(placa: String, posicion: String): Boolean {
        for (estacionamiento in listaEstacionamientos) {
            if (estacionamiento.getId() == posicion) {
                estacionamiento.ocupar(placa)
                return true
            }
        }
        return false
    }

    private fun getEstacionamientoEn(x: Int, y: Int): Estacionamiento? {
        listaEstacionamientos.forEach {
            if (it.getPosX() == x && it.getPosY() == y) {
                return it
            }
        }
        return null
    }

    private fun getParedEn(x: Int, y: Int): Pared? {
        listaParedes.forEach {
            if (it.getPosX() == x && it.getPosY() == y) {
                return it
            }
        }
        return null
    }

    private fun getEspacioTransitableEn(x: Int, y: Int): EspacioTransitable? {
        listaTransitables.forEach {
            if (it.getPosX() == x && it.getPosY() == y) {
                return it
            }
        }
        return null
    }

    override fun toString(): String {
        val nivelString = """
            Nivel $id: $name
                Color: $color
                Ubicacion de archivo: $structureFileName
                Mapa:

        """.trimIndent()

        var mapa = ""
        for (j in 0..ancho) {
            var linea = ""
            for (i in 0..largo) {
                if (getEstacionamientoEn(i, j) != null) {
                    linea += getEstacionamientoEn(i, j)
                } else if (getParedEn(i, j) != null) {
                    linea += getParedEn(i, j)
                } else {
                    linea += getEspacioTransitableEn(i, j)
                }
            }
            mapa += linea + "\n"
        }

        return nivelString + mapa
    }
}