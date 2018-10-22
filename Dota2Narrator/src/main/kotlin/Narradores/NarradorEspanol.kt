package Narradores

import interfaces.Narrator

class NarradorEspanol: Narrator {
    //FRASES PARA MOMENTOS DEL JUEGO
    override fun narrar (tipoEvento: String): String {
        var narrando = """
            -------------------
            Narrador:

        """.trimIndent()
        when(tipoEvento) {
            "bienvenida" -> {
                narrando += """
                    Bienvenido a Dota 2
                    -------------------
                    """.trimIndent()
            }
            "empezarJuego" -> {
                narrando += """
                    Que el juego comience...
                    -------------------
                    """.trimIndent()
            }
            "unKill" -> {
                narrando += """
                    Han matado a un heroe
                    -------------------
                """.trimMargin()
            }
            "dosOMasKills" -> {
                narrando += """
                    Han matado a $ heores
                    -------------------
                    """.trimIndent()
            }
            "cincoKills" -> {
                narrando += """
                    Han matado a 5 heroes
                    -------------------
                    """.trimIndent()
            }
            "matanTorre" -> {
                narrando += """
                    Han matado una torre
                    -------------------
                    """.trimIndent()
            }
            "direGana" -> {
                narrando += """
                    Gana Dire
                    -------------------
                    """.trimIndent()
            }
            "radiantGana" -> {
                narrando += """
                    Gana Radiant
                    -------------------
                    """.trimIndent()
            }
            else -> {
                narrando += """
                    Opcion no valida
                    -------------------
                    """.trimIndent()
            }
        }
        return narrando
    }
}