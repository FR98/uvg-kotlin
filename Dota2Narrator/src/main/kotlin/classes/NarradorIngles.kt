package classes

import interfaces.Narrator

class NarradorIngles: Narrator {
    //FRASES PARA MOMENTOS DEL JUEGO
    override fun narrar (tipoEvento: String): String {
        when(tipoEvento) {
            "bienvenida" -> {
                return "Welcome to Dota 2"
            }
            "empezarJuego" -> {
                return "Let the game begin..."
            }
            "unKill" -> {
                return "A hero has been killed"
            }
            "dosOMasKills" -> {
                return "They have killed $ heroes"
            }
            "cincoKills" -> {
                return "They have killed 5 heroes"
            }
            "matanTorre" -> {
                return "A tower has been killed"
            }
            "direGana" -> {
                return "Dire win"
            }
            "radiantGana" -> {
                return "Radiant win"
            }
            else -> {
                return "Incorrect option"
            }
        }
    }
}