import classes.BoxOfChocolate
import classes.Chocolate
import classes.ForrestGump

fun main(args: Array<String>) {
    val chocoCaja = BoxOfChocolate<Chocolate>(arrayListOf<Chocolate>(
            Chocolate("Cho1"),
            Chocolate("Cho2"),
            Chocolate("Cho3")
    ))
    val forrest = ForrestGump<Chocolate>()

    println("Pick Chocolate?")
    forrest.pickChocolate(chocoCaja.pickOne())
    println(forrest.chocolates)

    forrest.pickChocolate(chocoCaja.pickOne())
    println(forrest.chocolates)
}