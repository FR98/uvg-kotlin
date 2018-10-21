import com.github.kittinunf.fuel.Fuel
import interfaces.Narrator
import Narradores.*
import classes.*
import utilidades.*
import java.util.*

fun main(args: Array<String>) {
	println("Cargando...")
	//SE USA API DE HEROES DE DOTA 2
    val url = "https://next.json-generator.com/api/json/get/VkOhaUo5B"
	val (request, response, result) = Fuel.get(url).responseObject(Heroe.LecturaHeroeArrayDeserializer())
	val (heroesAPI, err) = result
    println("Cargando...")
	//println("Heroes:")
	//heroesAPI?.forEach{ println(it) }
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

				//GUARDAR TODOS LOS HEROES DEL API
				val heroes = arrayListOf<Heroe>()
				heroesAPI?.forEach{ heroes.add(it) }

				val equipoRadiant = Equipo()
				val equipoDire = Equipo()
				val partida = Partido<Narrator>(equipoRadiant, equipoDire, narradorDePartida)
				println(partida.bienvenida())

				//SELECCION DE HEROES
				var maxHeroes = 5
				var eleccion: Int
				val heroesDisponibles = arrayListOf<Heroe>()
				//SELECCIONAR 25 HEROES AL AZAR
				for (i in 1..20) {
					val randomID = Random().nextInt((heroes.size-1))
					heroesDisponibles.add(heroes[randomID])
					heroes.remove(heroes[randomID])
				}

				while(maxHeroes > 0) {
					println("\nSELECCION DE HEROES")
                    //ELECCION DE RADIANT
                    heroesDisponibles.forEach { println("${it.id}. ${it.localized_name} (${it.type})") }
					println("ELECCION RADIANT:")
					eleccion = readLine()!!.toInt()

                    for(h in heroesDisponibles) {
                        if (h.id == eleccion) {
                            //SE AGREGA EL HEROE AL EQUIPO RADIANT
                            partida.equipoRadiant.addHeroe(h)
                            println("${h.localized_name} agregado.")
                            heroesDisponibles.remove(h)
                            break
                        }
                    }

                    println()
                    //ELECCION DE DIRE
                    heroesDisponibles.forEach { println("${it.id}. ${it.localized_name} (${it.type})") }
                    println("ELECCION DIRE:")
                    eleccion = readLine()!!.toInt()

                    for(h in heroesDisponibles) {
                        if (h.id == eleccion) {
                            //SE AGREGA EL HEROE AL EQUIPO DIRE
                            partida.equipoDire.addHeroe(h)
                            println("${h.localized_name} agregado.")
                            heroesDisponibles.remove(h)
                            break
                        }
                    }

					maxHeroes -= 1
				}

                //INICIO DEL JUEGO

                println(partida.empezarJuego())



			}
			"3" -> continuarJugando = false
			else -> println("Opcion invalida")
		}

	} while (continuarJugando)
}