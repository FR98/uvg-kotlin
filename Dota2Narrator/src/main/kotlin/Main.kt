import com.github.kittinunf.fuel.Fuel
import classes.*
import interfaces.Narrator
import utilidades.*

fun main(args: Array<String>) {
    println("Cargando...")
    //SE USA API DE HEROES DE DOTA 2
    val url = "https://next.json-generator.com/api/json/get/VkOhaUo5B"
    val (request, response, result) = Fuel.get(url).responseObject(Heroe.LecturaHeroeArrayDeserializer())
    val (heroes, err) = result
    println("Cargando...")
    //println("Heroes:")
    //heroes?.forEach{ println(it) }
    Thread.sleep(5000)

    println("DOTA 2")
    var continuarJugando = true
    var opcion1: String
    var narradorDePartida: Narrator

    do {
        //SE PIDE NARRADOR
        println(menu1())
        opcion1 = readLine()!!

        when(opcion1) {
            "1", "2" -> {
                //ASIGNACION DE NARRADOR
                narradorDePartida = if (opcion1 == "1") {
                    NarradorEspanol()
                } else {
                    NarradorIngles()
                }

                val equipoRadiant = Equipo()
                val equipoDire = Equipo()
                val partida = Partido<Narrator>(equipoRadiant, equipoDire, narradorDePartida)
                println(partida.bienvenida())

                //SELECCION DE HEROES


            }
            "3" -> continuarJugando = false
            else -> println("Opcion invalida")
        }

    } while (continuarJugando)
}