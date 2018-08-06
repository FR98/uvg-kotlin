package main.classes

import main.utilidades.*

class Parqueo (
        private val id: Int,
        private val niveles: MutableList<Nivel> = mutableListOf()
) {
    fun addNewNivel(id: String, name: String, color: String, structureFileName: String): String {
        val idInt: Int = id.toInt()

        for (nivel in niveles) {
            if (nivel.id == idInt || nivel.name == name || nivel.color == color) {
                return "Nivel no aceptado"
            }
        }

        if (acceptedFile(structureFileName)) {
            val mapaNivel = fileToString(structureFileName)
            niveles.add(Nivel(idInt,name,color,structureFileName, mapaNivel))
            return "Nivel creado exitosamente"
        }
        return "Nivel no aceptado"

    }

    fun removeNivel(id: String): String {
        val idInt: Int = id.toInt()
        if ((idInt-1) < niveles.size) {
            niveles.removeAt(idInt-1)
            return "Nivel eliminado satisfactoriamente"
        }
        return "Nivel no encontrado"
    }

    fun isFull(): Boolean {
        for (nivel in niveles) {
            if (nivel.isFull()) {
                return true
            }
        }
        return false
    }

    fun newVehiculo(placa: String): String {
        for (nivel in niveles) {
            if (nivel.placas.contains(placa)) {
                return """
                    Vehiculo con placa: $placa encontrado en:
                    $nivel
                """.trimIndent()
            }
        }
        var nivelesDisponibles = ""
        for (nivel in niveles) {
            if (!nivel.isFull()) {
                nivelesDisponibles += "Nivel ${nivel.id}: ${nivel.name} \n"
            }
        }
        return nivelesDisponibles
    }

    fun verificarNivel(nivelID: String): String {
        for (nivel in niveles) {
            if (nivel.id == nivelID.toInt()) {
                if (!nivel.isFull()) {
                    return "$nivel"
                }
            }
        }
        return "Nivel incorrecto"
    }

    fun addVehiculoToNivel(placa: String, nivelID: String, posicion: String) {
        for (nivel in niveles) {
            if (nivel.id == nivelID.toInt()) {
                nivel.addVehiculo(placa, posicion)
            }
        }
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