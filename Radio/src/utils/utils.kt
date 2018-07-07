package main.utils

class Radio (
        val name: String,
        var isTurnOn: Boolean = false,
        var frequency: String = "FM",
        var station: Double = 0.0,
        var volume: Int = 0
) {
    fun menu(): String {
        if (isTurnOn == false) {
            return """
                    Menu:
                1. Encender
                2. Salir
            """.trimIndent()
        } else {
            return """
                Menu:
            1. Apagar
            2. Cambiar Frecuencia
            3. Subir estacion
            4. Bajar estacion
            5. Subir volumen
            6. Bajar volumen
            7. Salir
        """.trimIndent()
        }
    }
    fun turnOn() {
        isTurnOn = true
    }
    fun turnOff() {
        isTurnOn = false
    }
    fun changeFrequency() {
        if (frequency == "FM"){
            frequency = "AM"
            station = 1000.0
        } else {
            frequency = "FM"
            station = 87.0
        }
    }
    fun upperStation(step: Double) {
        if (frequency == "FM" && station < 100) {
            station += step
        } else if (frequency == "AM" && station < 1400){
            station += step
        }
    }
    fun lowerStation(step: Double) {
        if (frequency == "FM" && station > 87) {
            station -= step
        } else if (frequency == "AM" && station > 1000){
            station -= step
        }
    }
    fun moreVolume() {
        if (volume < 100) {
            volume += 1
        }
    }
    fun lessVolume() {
        if (volume > 0) {
            volume -= 1
        }
    }

    override fun toString(): String {
        return """
            Radio $name:
                On: $isTurnOn
                Frecuencia: $frequency
                Estacion: $station
                Volumen: $volume
        """.trimIndent()
    }
}