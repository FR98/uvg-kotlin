package classes

fun menu1(): String {
    //Menu Principal
    return """
            Menu Principal
        1. Dibujar figura
        2. Salir
    """.trimIndent()
}

fun menu2(): String {
    //Menu Secundario
    return """
            Menu
        1. Dibujar un cuadrado
        2. Dibujar un rectangulo
        3. Dibujar un triangulo
        4. Salir al menu principal
    """.trimIndent()
}