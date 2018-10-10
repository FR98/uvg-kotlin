package classes

data class Chocolate (
        val name: String
) {
    override fun toString(): String {
        return """
            Nombre: ${name}
        """.trimIndent()
    }
}