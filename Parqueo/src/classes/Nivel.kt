package main.classes

class Nivel (
        val id: Int,
        val name: String,
        val color: String,
        val structureFileName: String,
        val placas: MutableList<String> = mutableListOf(),
        var full: Boolean = false
) {
    fun getIDProp(): String {
        return "ID: $id"
    }

    fun getNameProp(): String {
        return "Name: $name"
    }

    fun getColorProp(): String {
        return "Color: $color"
    }

    fun isFull(): Boolean {
        //TODO
        return false
    }

    fun addVehiculo(placa: String, nivel: Int, posicion: String) {
        //TODO
    }
}