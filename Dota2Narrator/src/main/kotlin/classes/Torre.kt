package classes

data class Torre (
        var isAlive: Boolean = true
){
    fun muereTorre() {
        isAlive = false
    }
}