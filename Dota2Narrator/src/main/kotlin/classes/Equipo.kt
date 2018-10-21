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

    fun kill(cant: Int): Boolean {
        //ELIMINACION RANDOM DE HEROES
        if (heroes.size > cant) {
            var kills = cant
            while (kills>0) {
                val randomID = Random().nextInt((heroes.size-1))
                heroes.removeAt(randomID)
                kills -= 1
            }
            return true
        }
        return false
    }

    fun matarTorre(): Boolean {
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
            return true
        }
        //Si retorna falso es porque ya no hay torres vivas y se puede matar al ancient
        return false
    }

    fun matarAncient(): Boolean {
        //LOGICA PARA MATAR EL ANCIENT DEL EQUIPO
        for (t in torres) {
            if (t.isAlive) {
                return false
            }
        }
        ancient.muereAncient()
        return true
    }
}