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
        if (isRadiantKiller) {
            equipoDire.kill(1)
        } else {
            equipoRadiant.kill(1)
        }
        return narrarPartida(narrator, "unKill")
    }

    fun ocurrieronDosOMasKills(isRadiantKiller: Boolean, kills: Int): String {
        //MUEREN DOS O MAS HEROES
        if (isRadiantKiller) {
            equipoDire.kill(kills)
        } else {
            equipoRadiant.kill(kills)
        }
        return narrarPartida(narrator, "dosOMasKills")
    }

    fun ocurrieronCincoKills(isRadiantKiller: Boolean): String {
        //MUEREN CINCO HEROES
        if (isRadiantKiller) {
            equipoDire.kill(5)
        } else {
            equipoRadiant.kill(5)
        }
        return narrarPartida(narrator, "cincoKills")
    }

    fun matanUnaTorre(isRadiantKiller: Boolean): String {
        //MUERE TORRE
        if (isRadiantKiller) {
            equipoDire.matarTorre()
        } else {
            equipoRadiant.matarTorre()
        }
        return narrarPartida(narrator, "matanTorre")
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