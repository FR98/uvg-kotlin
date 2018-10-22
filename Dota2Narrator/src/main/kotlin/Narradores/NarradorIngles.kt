package Narradores

import interfaces.Narrator

class NarradorIngles: Narrator {
    //FRASES PARA MOMENTOS DEL JUEGO
    override fun narrar (tipoEvento: String): String {
        var narrando = """
            -------------------
            Narrator:

        """.trimIndent()
        when(tipoEvento) {
            "bienvenida" -> {
                narrando += """
                    Welcome to Dota 2
                    -------------------
                    """.trimIndent()
            }
            "empezarJuego" -> {
                narrando += """
                    Let the game begin...
                    -------------------
                    """.trimIndent()
            }
            "unKill" -> {
                narrando += """
                    A hero has been killed
                    -------------------
                    """.trimMargin()
            }
            "dosOMasKills" -> {
                narrando += """
                    They have killed $ heroes
                    -------------------
                    """.trimIndent()
            }
            "cincoKills" -> {
                narrando += """
                    They have killed 5 heroes
                    -------------------
                    """.trimIndent()
            }
            "matanTorre" -> {
                narrando += """
                    A tower has been killed
                    -------------------
                    """.trimIndent()
            }
            "direGana" -> {
                narrando += """
                    Dire win
                    -------------------
                    """.trimIndent()
            }
            "radiantGana" -> {
                narrando += """
                    Radiant win
                    -------------------
                    """.trimIndent()
            }
            else -> {
                narrando += """
                    Incorrect option
                    -------------------
                    """.trimIndent()
            }
        }
        return narrando
    }
}