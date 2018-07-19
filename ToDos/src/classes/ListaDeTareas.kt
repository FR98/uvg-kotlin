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
}