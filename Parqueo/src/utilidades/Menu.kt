package main.utilidades

fun menu1(): String {
    return """

                    Menu Principal:
                1. Administrador
                2. Conductor
                3. Salir
                Ingrese su opcion:
            """.trimIndent()
}

fun menu2(): String {
    return """

                    Menu Admin:
                1. Crear Nivel
                2. Eliminar Nivel
                3. Ver todos los niveles
                4. Salir
                Ingrese su opcion:
            """.trimIndent()
}

fun menu3(): String {
    return """
                    Menu Conductor:
                1. Ingresar placa
                2. Salir
                Ingrese su opcion:
            """.trimIndent()
}