package classes

data class Chocolate (
        val name: String
): Candy () {
    override fun toString(): String {
        return name
    }
}