package main.classes

class Parqueo (
        val id: Int,
        val niveles: MutableList<Nivel> = mutableListOf()
) {
    fun addNewNivel(id: Int, name: String, color: String, structureFileName: String) {
        //niveles.add()
    }

    fun getNivelesProp(): String {
        //for que lee todos los niveles y muestra un detalle de c/u de sus datos y dibujo
        return ""
    }

    fun processFile(strucctureFileName: String) {
        //TODO
    }

    fun removeNivel(id: Int) {
        //TODO
    }

    fun isFull(): Boolean {
        ///TODO
        return false
    }

    fun newVehiculo(placa: String): String {
        //TODO
        return ""
    }

    fun getNivelMap(id: Int): String {
        //TODO
        return ""
    }

    fun addVehiculoToNivel(posicion: String) {
        //TODO
    }
}