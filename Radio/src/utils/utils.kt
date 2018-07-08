//Francisco Rosal 18676
//07/07/2018

package main.utils

class Radio (
        //Propiedades
        val name: String,
        var isTurnOn: Boolean = false,
        var frequency: String = "FM",
        var station: Double = 87.0,
        var volume: Int = 0
) {
    //Metodos
    //Menu
    fun menu(): String {
        if (isTurnOn) {
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
        } else {
            return """
                    Menu:
                1. Encender
                2. Salir

            """.trimIndent()
        }
    }
    //Enciende la radio
    fun turnOn() {
        isTurnOn = true
    }
    //Apaga la radio
    fun turnOff() {
        isTurnOn = false
    }
    //Cambia frecuencia
    fun changeFrequency() {
        if (frequency == "FM"){
            frequency = "AM"
            station = 1000.0
        } else {
            frequency = "FM"
            station = 87.0
        }
    }
    //Sube la estacion
    fun upperStation(step: Double) {
        if (frequency == "FM" && station < 100) {
            if ((station + step) < 100) {
                station += step
            } else {
                station = 100.0
            }
        } else if (frequency == "AM" && station < 1400){
            if ((station + step) < 1400) {
                station += step
            } else {
                station = 1400.0
            }
        }
    }
    //Baja la estacion
    fun lowerStation(step: Double) {
        if (frequency == "FM" && station > 87) {
            if ((station - step) > 87) {
                station -= step
            } else {
                station = 87.0
            }
        } else if (frequency == "AM" && station > 1000){
            if ((station - step) > 1000) {
                station -= step
            } else {
                station = 1000.0
            }
        }
    }
    //Sube volumen
    fun moreVolume() {
        if (volume < 100) {
            volume += 1
        }
    }
    //Baja volumen
    fun lessVolume() {
        if (volume > 0) {
            volume -= 1
        }
    }
    //Metodo de impresion en pantalla
    override fun toString(): String {
        return """
            Radio $name:
                On: $isTurnOn
                ${if (isTurnOn) {"Frecuencia: $frequency"} else {""}}
                ${if (isTurnOn) {"Estacion: $station"} else {""}}
                ${if (isTurnOn) {"Volumen: $volume"} else {""}}

        """.trimIndent()
    }
}