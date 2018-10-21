package classes

import interfaces.Narrator

class NarradorEspanol: Narrator {
    //FRASES PARA MOMENTOS DEL JUEGO
    override fun narrar (tipoEvento: String): String {
        when(tipoEvento) {
            "bienvenida" -> {
                return "Bienvenido a Dota 2"
            }
            "empezarJuego" -> {
                return "Que el juego comience..."
            }
            "unKill" -> {
                return "Han matado a un heroe"
            }
            "dosOMasKills" -> {
                return "Han matado a $ heores"
            }
            "cincoKills" -> {
                return "Han matado a 5 heroes"
            }
            "matanTorre" -> {
                return "Han matado una torre"
            }
            "direGana" -> {
                return "Gana Dire"
            }
            "radiantGana" -> {
                return "Gana Radiant"
            }
            else -> {
                return "Opcion no valida"
            }
        }
    }
}