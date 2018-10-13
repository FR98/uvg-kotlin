package classes

data class Ancient (
        var isAlive: Boolean = true
){
    fun muereAncient() {
        isAlive = false
    }
}