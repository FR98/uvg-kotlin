package Narradores

import interfaces.Narrator

class NarradorEspanol: Narrator {
    //FRASES PARA MOMENTOS DEL JUEGO
    override fun narrar (tipoEvento: String): String {
        when(tipoEvento) {
            "bienvenida" -> {
                return """

                    Bienvenido a Dota 2

                    """.trimIndent()
            }
            "empezarJuego" -> {
                return """

                    Que el juego comience...

                    """.trimIndent()
            }
            "unKill" -> {
                return """

                    Han matado a un heroe

                """.trimMargin()
            }
            "dosOMasKills" -> {
                return """

                    Han matado a $ heores

                    """.trimIndent()
            }
            "cincoKills" -> {
                return """

                    Han matado a 5 heroes

                    """.trimIndent()
            }
            "matanTorre" -> {
                return """

                    Han matado una torre

                    """.trimIndent()
            }
            "direGana" -> {
                return """

                    Gana Dire

                    """.trimIndent()
            }
            "radiantGana" -> {
                return """

                    Gana Radiant

                    """.trimIndent()
            }
            else -> {
                return """

                    Opcion no valida

                    """.trimIndent()
            }
        }
    }
}