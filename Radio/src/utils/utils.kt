package main.utils

class Radio (
        val name: String,
        var isTurnOn: Boolean = false,
        var frequency: String = "FM",
        var station: Double = 0.0,
        var volume: Int = 0
) {
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
                On/Off: $isTurnOn
                Frequency: $frequency
                Station: $station
                Volume: $volume
        """.trimIndent()
    }
}