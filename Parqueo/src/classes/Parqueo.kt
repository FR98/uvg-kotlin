package main.classes

import main.utilidades.*

class Parqueo (
        private val id: Int,
        private val niveles: MutableList<Nivel> = mutableListOf()
) {
    fun addNewNivel(id: String, name: String, color: String, structureFileName: String): String {
        for (nivel in niveles) {
            if (nivel.id == id.toInt() || nivel.name == name || nivel.color == color) {
                return "Nivel no aceptado"
            }
        }

        if (acceptedFile(structureFileName)) {
            val mapaNivel = fileToString(structureFileName)
            niveles.add(Nivel(id.toInt(),name,color,structureFileName, mapaNivel))
            return "Nivel creado exitosamente"
        }
        return "Nivel no aceptado"

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

    fun placaEnParqueo(placa: String): Boolean {
        for (nivel in niveles) {
            if (nivel.placas.contains(placa)) {
                return true
            }
        }
        return false
    }

    fun mostrarUbicacionPlaca(placa: String): String {
        var ubicacion = ""
        for (nivel in niveles) {
            if (nivel.placas.contains(placa)) {
                ubicacion += """
                    Vehiculo con placa: $placa encontrado en:
                    $nivel
                """.trimIndent()
            }
        }
        return ubicacion
    }

    fun mostrarNivelesDisponibles(): String {
        var nivelesDisponibles = "\nNiveles Disponibles: \n"
        for (nivel in niveles) {
            if (!nivel.isFull()) {
                nivelesDisponibles += "Nivel ${nivel.id}: ${nivel.name} \n"
            }
        }
        return nivelesDisponibles
    }

    fun getNivel(nivelID: String): Nivel? {
        for (nivel in niveles) {
            if (nivel.id == nivelID.toInt()) {
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