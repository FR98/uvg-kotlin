package main.classes

class ListaDeTareas(
        val name: String,
        val tareas: ArrayList<Tarea> = ArrayList()
) {
    //Metodos

    fun addTarea(tareaNueva: Tarea) {
        tareas.add(tareaNueva)
    }
    /*
    fun deleteTarea() {
        pass
    }*/

    override fun toString(): String {
        val tareasNames = tareas.joinToString()
        return """
            Lista: $name
            Tareas: $tareasNames
        """.trimIndent()
    }
}