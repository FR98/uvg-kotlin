package classes

import interfaces.Narrator

class Partido<T> (
        val equipoRadiant: Equipo,
        val equipoDire: Equipo,
        val narrator: T
) where T : Narrator {

    //FUNCION PARA NARRAR EL JUEGO
    fun narrarPartida(narrador: Narrator, evento: String): String {
        return narrador.narrar(evento)
    }

    fun bienvenida(): String {
        //BIENVENIDA DEL JUEGO
        return narrarPartida(narrator, "bienvenida")
    }

    fun empezarJuego(): String {
        //INICIO DEL JUEGO
        return narrarPartida(narrator, "empezarJuego")
    }

    fun ocurrioUnKill(isRadiantKiller: Boolean): String {
        //MUERE UN HEROE
        val muerteExitosa = if (isRadiantKiller) {
            equipoDire.kill(1)
        } else {
            equipoRadiant.kill(1)
        }

        return if (muerteExitosa) {
            narrarPartida(narrator, "unKill")
        } else {
            "Ya se mataron todos los heroes del equipo"
        }
    }

    fun ocurrieronDosOMasKills(isRadiantKiller: Boolean, kills: Int): String {
        //MUEREN DOS O MAS HEROES
        val muertesExitosas = if (isRadiantKiller) {
            equipoDire.kill(kills)
        } else {
            equipoRadiant.kill(kills)
        }

        return if (muertesExitosas) {
            narrarPartida(narrator, "dosOMasKills")
        } else {
            "No se puede matar esa cantidad"
        }
    }

    fun ocurrieronCincoKills(isRadiantKiller: Boolean): String {
        //MUEREN CINCO HEROES
        val muertesExitosas = if (isRadiantKiller) {
            equipoDire.kill(5)
        } else {
            equipoRadiant.kill(5)
        }

        return if (muertesExitosas) {
            narrarPartida(narrator, "cincoKills")
        } else {
            "No se puede matar esa cantidad"
        }
    }

    fun matanUnaTorre(isRadiantKiller: Boolean): String {
        //MUERE TORRE
        val muerteExitosa = if (isRadiantKiller) {
            equipoDire.matarTorre()
        } else {
            equipoRadiant.matarTorre()
        }

        return if (muerteExitosa) {
            narrarPartida(narrator, "matanTorre")
        } else {
            "Ya murio la ultima torre del equipo"
        }
    }

    fun hayTorresVivas(): Boolean {
        var torresRadiantAlive = 0
        var torresDireAlive = 0
        for (t in equipoRadiant.torres) {
            if (t.isAlive) { torresRadiantAlive += 1 }
        }
        for (t in equipoDire.torres) {
            if (t.isAlive) { torresDireAlive += 1 }
        }
        if (torresDireAlive == 0 || torresRadiantAlive == 0) {
            return false
        }
        return true
    }

    fun direGana(): String {
        //GANA EL EQUIPO DIRE
        equipoRadiant.matarAncient()
        return narrarPartida(narrator, "direGana")
    }

    fun radiantGana(): String {
        //GANA EL EQUIPO RADIANT
        equipoDire.matarAncient()
        return narrarPartida(narrator, "radiantGana")
    }
}