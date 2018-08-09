package main.classes

import main.utilidades.*

class Parqueo (
        private val id: Int,
        private val niveles: MutableList<Nivel> = mutableListOf()
) {
    fun addNewNivel(id: String, name: String, color: String, structureFileName: String): String {
        for (nivel in niveles) {
            if (nivel.getId() == id.toInt() || nivel.getName() == name || nivel.getColor() == color) {
                return "Nivel no aceptado"
            }
        }

        if (acceptedFile(structureFileName)) {
            val mapaNivel = fileToString(structureFileName)
            createNivel(id.toInt(), name, color, structureFileName, mapaNivel)
            return "Nivel creado exitosamente"
        }
        return "Nivel no aceptado"
    }

    private fun createNivel(id: Int, name: String, color: String, structureFileName: String, mapaNivel: MutableList<MutableList<String>>) {
        val listaParedes = mutableListOf<Pared>()
        val listaEspacios = mutableListOf<EspacioTransitable>()
        val listaEstacionamiento = mutableListOf<Estacionamiento>()
        val ancho = mapaNivel.size
        var largo = 0

        for (l in mapaNivel.indices) {
            for (e in mapaNivel[l].indices) {
                when (mapaNivel[l][e]) {
                    "*" -> {
                        listaParedes.add(Pared(e, l))
                    }
                    " " -> {
                        listaEspacios.add(EspacioTransitable(e, l))
                    }
                    else -> {
                        listaEstacionamiento.add(Estacionamiento(mapaNivel[l][e], e, l))
                    }
                }
            }
            largo = mapaNivel[l].size
        }
        niveles.add(Nivel(id, name, color, structureFileName, ancho, largo, listaEstacionamiento, listaParedes, listaEspacios))
    }

    fun removeNivel(nivelID: String): String {
        if (niveles.contains(getNivel(nivelID))) {
            niveles.remove(getNivel(nivelID))
            return "Nivel eliminado satisfactoriamente"
        }
        return "Nivel no encontrado"
    }

    fun isFull(): Boolean {
        val nivelesLlenos = mutableListOf<Boolean>()
        for (nivel in niveles) {
            nivelesLlenos.add(nivel.isFull())
        }
        if (nivelesLlenos.contains(false)) {
            return false
        }
        return true
    }

    fun placaEnParqueo(placa: String): String? {
        for (nivel in niveles) {
            if (nivel.getEstacionamientoConPlaca(placa) != null) {
                return """
                    Placa: $placa encontrada en nivel ${nivel.getId()}: ${nivel.getName()}

                    $nivel

                """.trimIndent()
            }
        }
        return null
    }

    fun mostrarNivelesDisponibles(): String {
        var nivelesDisponibles = "\nNiveles Disponibles: \n"
        for (nivel in niveles) {
            if (!nivel.isFull()) {
                nivelesDisponibles += "Nivel ${nivel.getId()}: ${nivel.getName()} \n"
            }
        }
        return nivelesDisponibles
    }

    fun getNivel(nivelID: String): Nivel? {
        for (nivel in niveles) {
            if (nivel.getId() == nivelID.toInt()) {
                return nivel
            }
        }
        return null
    }

    fun nivelDisponible(nivelID: String): Boolean {
        if (niveles.contains(getNivel(nivelID))) {
            if (getNivel(nivelID)!!.isFull()) {
                return false
            }
            return true
        }
        return false
    }

    fun addVehiculoToNivel(placa: String, nivelID: String, posicion: String): Boolean {
        return getNivel(nivelID)!!.addVehiculo(placa, posicion)
    }

    override fun toString(): String {
        var parqueo = "Parqueo $id \n"
        if (niveles.size == 0) {
            parqueo += "No hay niveles"
        } else {
            for (nivel in niveles) {
                parqueo += """

                $nivel

            """.trimIndent()
            }
        }
        return parqueo
    }
}