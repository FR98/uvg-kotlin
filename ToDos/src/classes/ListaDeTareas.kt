package main.classes

class ListaDeTareas(
        val name: String,
        val tareas: ArrayList<Tarea> = ArrayList()
) {
    fun addTarea(tareaNueva: Tarea) {
        tareas.add(tareaNueva)
    }
    /*
    fun deleteTarea() {
        pass
    }*/

    override fun toString(): String {
        return """
            Lista: $name
                Tareas:
                ${tareas.forEach {it.name + "\n"}}
        """.trimIndent()
    }
}