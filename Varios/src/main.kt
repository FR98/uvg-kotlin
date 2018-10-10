import Animales.Perro
import People.Profesionales.Programador
import behavior.Walker

fun main(args: Array<String>) {
    val willi = Programador("Willi", 19, "Python")
    val hans = Perro("Hans", "Pastor Aleman")

    println(willi)
    willi.age = 10
    println(willi)

    pasear(willi, 10)
    pasear(hans, 20)
}

fun pasear(walker: Walker, steps: Int) {
    for (i in 0 until steps) {
        walker.walk()
    }
}