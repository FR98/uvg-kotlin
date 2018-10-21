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
            return if (equipoDire.kill(1)) {
                narrarPartida(narrator, "unKill")
            } else {
                "false"
            }
        } else {
            return if (equipoRadiant.kill(1)) {
                narrarPartida(narrator, "unKill")
            } else {
                "false"
            }
        }
    }

    fun ocurrieronDosOMasKills(isRadiantKiller: Boolean, kills: Int): String {
        //MUEREN DOS O MAS HEROES
        if (isRadiantKiller) {
            return if (equipoDire.kill(kills)) {
                narrarPartida(narrator, "dosOMasKills")
            } else {
                "false"
            }
        } else {
            return if (equipoRadiant.kill(kills)) {
                narrarPartida(narrator, "dosOMasKills")
            } else {
                "false"
            }
        }
    }

    fun ocurrieronCincoKills(isRadiantKiller: Boolean): String {
        //MUEREN CINCO HEROES
        if (isRadiantKiller) {
            return if (equipoDire.kill(5)) {
                narrarPartida(narrator, "cincoKills")
            } else {
                "false"
            }
        } else {
            return if (equipoRadiant.kill(5)) {
                narrarPartida(narrator, "cincoKills")
            } else {
                "false"
            }
        }
    }

    fun matanUnaTorre(isRadiantKiller: Boolean): String {
        //MUERE TORRE
        if (isRadiantKiller) {
            return if (equipoDire.matarTorre()) {
                narrarPartida(narrator, "matanTorre")
            } else {
                "false"
            }
        } else {
            return if (equipoRadiant.matarTorre()) {
                narrarPartida(narrator, "matanTorre")
            } else {
                "false"
            }
        }
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