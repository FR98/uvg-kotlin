package main.classes

fun menu1(): String {
    return """
                    Menu:
                1. Crear Lista de Tareas
                2. Salir
            """.trimIndent()
}

fun menu2(): String {
    return """
                    Menu:
                1. Crear Lista de Tareas
                2. Ver Listas de Tareas
                3. Seleccionar Lista de Tareas
                4. Salir
            """.trimIndent()
}

fun menu3(lista: ListaDeTareas): String {
    return """
                1. Deseleccionar Lista Actual: ${lista.name}
                2. Agregar una Tarea a Lista ${lista.name}
                3. Completar una Tarea
                4. Ver Tareas en la Lista ${lista.name}
                5. Salir
            """.trimIndent()
}