package main.classes

class Tarea(
        val name: String,
        var completada: Boolean = false
) {
    fun finalizarTarea() {
        completada = true
    }
}