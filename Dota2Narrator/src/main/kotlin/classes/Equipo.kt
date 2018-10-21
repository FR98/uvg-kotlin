package classes

import java.util.*

class Equipo (
        val heroes: ArrayList<Heroe> = arrayListOf(),
        val torres: ArrayList<Torre> = arrayListOf( Torre(), Torre(), Torre(), Torre(), Torre(), Torre() ),
        val ancient: Ancient = Ancient()
){
    fun addHeroe(h: Heroe) {
        //AÑADE LOS HEROES DEL EQUIPO
        heroes.add(h)
    }

    fun kill(cant: Int): String {
        //ELIMINACION RANDOM DE HEROES
        if (heroes.size > cant) {
            var kills = cant
            do {
                val randomID = Random().nextInt((heroes.size-1))
                heroes.removeAt(randomID)
                kills -= 1
            } while (kills>0)
            return "Murieron $cant heroes"
        }
        return "No se puede hacer esa cantidad de kills"
    }

    fun matarTorre(): String {
        //LOGICA PARA MATAR TORRES DEL EQUIPO
        val torresAlive = arrayListOf<Torre>()
        for (t in torres) {
            if (t.isAlive) { torresAlive.add(t) }
        }
        if (torresAlive.size > 0) {
            var cont = true
            do {
                val randomID = Random().nextInt((torres.size-1))
                if (torres[randomID].isAlive) {
                    torres[randomID].muereTorre()
                    cont = false
                }
            } while (cont)
            return "Murio 1 torre"
        }
        return "Ya se eliminaron todas las torres"
    }

    fun matarAncient(): String {
        //LOGICA PARA MATAR EL ANCIENT DEL EQUIPO
        for (t in torres) {
            if (t.isAlive) {
                return "Aun hay torres vivas"
            }
        }
        ancient.muereAncient()
        return "Muere Ancient"
    }
}