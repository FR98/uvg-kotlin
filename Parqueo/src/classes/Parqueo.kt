package main.classes

import main.utilidades.*

class Parqueo (
        val id: Int,
        val niveles: MutableList<Nivel> = mutableListOf()
) {
    fun addNewNivel(id: String, name: String, color: String, structureFileName: String): String {
        val idInt: Int = id.toInt()
        if (acceptedFile(structureFileName)) {
            val mapaNivel = fileToString(structureFileName)
            niveles.add(Nivel(idInt,name,color,structureFileName, mapaNivel))
            return "Nivel creado exitosamente"
        } else {
            return "Nivel no aceptado"
        }
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
        ///TODO
        return false
    }

    fun newVehiculo(placa: String): String {
        //TODO
        return ""
    }

    fun addVehiculoToNivel(posicion: String) {
        //TODO
    }

    override fun toString(): String {
        var parqueo: String = ""
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