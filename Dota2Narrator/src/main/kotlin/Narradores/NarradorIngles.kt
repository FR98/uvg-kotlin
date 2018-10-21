package Narradores

import interfaces.Narrator

class NarradorIngles: Narrator {
    //FRASES PARA MOMENTOS DEL JUEGO
    override fun narrar (tipoEvento: String): String {
        when(tipoEvento) {
            "bienvenida" -> {
                return """

                    Welcome to Dota 2

                    """.trimIndent()
            }
            "empezarJuego" -> {
                return """

                    Let the game begin...

                    """.trimIndent()
            }
            "unKill" -> {
                return """

                    A hero has been killed

                """.trimMargin()
            }
            "dosOMasKills" -> {
                return """

                    They have killed $ heroes

                    """.trimIndent()
            }
            "cincoKills" -> {
                return """

                    They have killed 5 heroes

                    """.trimIndent()
            }
            "matanTorre" -> {
                return """

                    A tower has been killed"

                    """.trimIndent()
            }
            "direGana" -> {
                return """

                    Dire win

                    """.trimIndent()
            }
            "radiantGana" -> {
                return """

                    Radiant win

                    """.trimIndent()
            }
            else -> {
                return """

                    Incorrect option

                    """.trimIndent()
            }
        }
    }
}