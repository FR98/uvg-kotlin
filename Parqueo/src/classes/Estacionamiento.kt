package main.classes

class Estacionamiento (
        private val id: String,
        private val posX: Int,
        private val posY: Int,
        private var placa: String = "",
        private var isOcupado: Boolean = false
) {
    fun getId(): String {
        return id
    }

    fun getIsOcupado(): Boolean {
        return isOcupado
    }

    fun ocupar(placa: String) {
        this.placa = placa
        this.isOcupado = true
    }

    override fun toString(): String {
        if (isOcupado) {
            return "@"
        }
        return id
    }
}