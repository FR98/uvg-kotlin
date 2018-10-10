package classes

abstract class Candy (
        var isOpen: Boolean = false
) {
    fun openCandy() {
        isOpen = true
    }
}