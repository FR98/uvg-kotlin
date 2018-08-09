package main.classes

class EspacioTransitable (
        private val posX: Int,
        private val posY: Int
) {
    fun getPosX(): Int {
        return posX
    }

    fun getPosY(): Int {
        return posY
    }

    override fun toString(): String {
        return " "
    }
}