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

                var continuarEleccion: Boolean
                while(maxHeroes > 0) {
                    println("\nSELECCION DE HEROES")
                    continuarEleccion = true

                    //ELECCION DE RADIANT
                    do {
                        heroesDisponibles.forEach { println("${it.id}. ${it.localized_name} (${it.type})") }
                        println("ELECCION RADIANT:")
                        eleccion = readLine()!!.toInt()

                        for(h in heroesDisponibles) {
                            if (h.id == eleccion) {
                                //SE AGREGA EL HEROE AL EQUIPO RADIANT
                                partida.equipoRadiant.addHeroe(h)
                                println("${h.localized_name} agregado.")
                                heroesDisponibles.remove(h)
                                continuarEleccion = false
                                break
                            }
                        }
                    } while (continuarEleccion)

                    continuarEleccion = true
                    println()
                    //ELECCION DE DIRE
                    do {
                        heroesDisponibles.forEach { println("${it.id}. ${it.localized_name} (${it.type})") }
                        println("ELECCION DIRE:")
                        eleccion = readLine()!!.toInt()

                        for(h in heroesDisponibles) {
                            if (h.id == eleccion) {
                                //SE AGREGA EL HEROE AL EQUIPO DIRE
                                partida.equipoDire.addHeroe(h)
                                println("${h.localized_name} agregado.")
                                heroesDisponibles.remove(h)
                                continuarEleccion = false
                                break
                            }
                        }
                    } while (continuarEleccion)

					maxHeroes -= 1
				}

                //INICIO DEL JUEGO
                println(partida.empezarJuego())

                var noHayGanador = true

                do {
                    var fueRadiant: Boolean
                    //Estado del juego
                    var torresRadiantVivas = 0
                    partida.equipoRadiant.torres.forEach { if (it.isAlive) { torresRadiantVivas += 1 } }
                    var torresDireVivas = 0
                    partida.equipoDire.torres.forEach { if (it.isAlive) { torresDireVivas += 1 } }
                    println("Radiant: Heroes:${partida.equipoRadiant.heroes.size}, Torres:${torresRadiantVivas}")
                    println("Dire: Heroes:${partida.equipoDire.heroes.size}, Torres:${torresDireVivas}")

                    if (partida.hayTorresVivas()) {
                        println(menu2())
                        val opcion2 = readLine()!!

                        when(opcion2) {
                            "1" -> {
                                //MATAN HEROE)
                                //Mato Radiant o Dire
                                var radiantODire = false
                                do {
                                    println("Fue Radiant quien mato? si/no")
                                    val fueRadiantLec = readLine()!!
                                    when(fueRadiantLec) {
                                        "si", "no" -> {
                                            radiantODire = true
                                            fueRadiant = fueRadiantLec == "si"

                                            //Cantidad de muertes
                                            var cantidadCorrecta = false
                                            do {
                                                println("Cuantas muertes? 0-5")
                                                val cantidadMuertes = readLine()!!
                                                when(cantidadMuertes) {
                                                    "0" -> {
                                                        cantidadCorrecta = true
                                                    }
                                                    "1" -> {
                                                        //Ocurre un kill
                                                        cantidadCorrecta = true
                                                        println(partida.ocurrioUnKill(fueRadiant))
                                                    }
                                                    "2", "3", "4" -> {
                                                        //Ocurren dos o mas kills
                                                        val cantMuertesInt = cantidadMuertes.toInt()
                                                        cantidadCorrecta = true
                                                        println(partida.ocurrieronDosOMasKills(fueRadiant, cantMuertesInt))
                                                    }
                                                    "5" -> {
                                                        //Ocurren 5 kills
                                                        cantidadCorrecta = true
                                                        println(partida.ocurrieronCincoKills(fueRadiant))
                                                    }
                                                    else -> println("Opcion invalida")
                                                }
                                            } while (!cantidadCorrecta)

                                        }
                                        else -> println("Opcion invalida")
                                    }
                                } while (!radiantODire)

                            }
                            "2" -> {
                                //MATAN TORRE
                                //Mato Radiant o Dire
                                var radiantODire = false
                                do {
                                    println("Fue Radiant quien mato? si/no")
                                    val fueRadiantLec = readLine()!!
                                    when(fueRadiantLec) {
                                        "si", "no" -> {
                                            radiantODire = true
                                            fueRadiant = fueRadiantLec == "si"
                                            println(partida.matanUnaTorre(fueRadiant))
                                        }
                                        else -> println("Opcion invalida")
                                    }
                                } while (!radiantODire)
                            }
                            else -> println("Opcion invalida")
                        }
                    } else {
                        println(menu3())
                        val opcion3 = readLine()!!

                        when(opcion3) {
                            "1" -> {
                                //MATAN HEROE)
                                //Mato Radiant o Dire
                                var radiantODire = false
                                do {
                                    println("Fue Radiant quien mato? si/no")
                                    val fueRadiantLec = readLine()!!
                                    when(fueRadiantLec) {
                                        "si", "no" -> {
                                            radiantODire = true
                                            fueRadiant = fueRadiantLec == "si"

                                            //Cantidad de muertes
                                            var cantidadCorrecta = false
                                            do {
                                                println("Cuantas muertes? 0-5")
                                                val cantidadMuertes = readLine()!!
                                                when(cantidadMuertes) {
                                                    "0" -> {
                                                        cantidadCorrecta = true
                                                    }
                                                    "1" -> {
                                                        //Ocurre un kill
                                                        cantidadCorrecta = true
                                                        println(partida.ocurrioUnKill(fueRadiant))
                                                    }
                                                    "2", "3", "4" -> {
                                                        //Ocurren dos o mas kills
                                                        val cantMuertesInt = cantidadMuertes.toInt()
                                                        cantidadCorrecta = true
                                                        println(partida.ocurrieronDosOMasKills(fueRadiant, cantMuertesInt))
                                                    }
                                                    "5" -> {
                                                        //Ocurren 5 kills
                                                        cantidadCorrecta = true
                                                        println(partida.ocurrieronCincoKills(fueRadiant))
                                                    }
                                                    else -> println("Opcion invalida")
                                                }
                                            } while (!cantidadCorrecta)

                                        }
                                        else -> println("Opcion invalida")
                                    }
                                } while (!radiantODire)

                            }
                            "2" -> {
                                //MATAN TORRE
                                //Mato Radiant o Dire
                                var radiantODire = false
                                do {
                                    println("Fue Radiant quien mato? si/no")
                                    val fueRadiantLec = readLine()!!
                                    when(fueRadiantLec) {
                                        "si", "no" -> {
                                            radiantODire = true
                                            fueRadiant = fueRadiantLec == "si"
                                            println(partida.matanUnaTorre(fueRadiant))
                                        }
                                        else -> println("Opcion invalida")
                                    }
                                } while (!radiantODire)
                            }
                            "3" -> {
                                //MATAN ANCIENT
                                //Mato Radiant o Dire
                                var radiantODire = false
                                do {
                                    println("Fue Radiant quien mato? si/no")
                                    val fueRadiantLec = readLine()!!
                                    when(fueRadiantLec) {
                                        "si", "no" -> {
                                            radiantODire = true
                                            fueRadiant = fueRadiantLec == "si"

                                            if (fueRadiant && (torresDireVivas == 0)) {
                                                println(partida.radiantGana())
                                                noHayGanador = false
                                            } else if (!fueRadiant && (torresRadiantVivas == 0)) {
                                                println(partida.direGana())
                                                noHayGanador = false
                                            } else {
                                                println("Aun quedan torres vivas")
                                            }
                                        }
                                        else -> println("Opcion invalida")
                                    }
                                } while (!radiantODire)
                            }
                            else -> println("Opcion invalida")
                        }
                    }
                } while (noHayGanador)
			}
			"3" -> continuarJugando = false
			else -> println("Opcion invalida")
		}

	} while (continuarJugando)
}