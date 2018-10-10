import classes.BoxOfChocolate
import classes.Chocolate
import classes.ForrestGump

fun main(args: Array<String>) {
    val forrest = ForrestGump()
    val chocoCaja = BoxOfChocolate<Chocolate>(arrayListOf<Chocolate>(
            Chocolate("Chocolate1"),
            Chocolate("Chocolate2"),
            Chocolate("Chocolate3"),
            Chocolate("Chocolate4"),
            Chocolate("Chocolate5"),
            Chocolate("Chocolate6"),
            Chocolate("Chocolate7"),
            Chocolate("Chocolate8"),
            Chocolate("Chocolate9")
    ))

    println("Pick Chocolate")
    forrest.pickChocolate(chocoCaja.pickOne())
    println("Chocolates de Forrest: ${forrest.chocolates}")

    forrest.pickChocolate(chocoCaja.pickOne())
    println("Chocolates de Forrest: ${forrest.chocolates}")

    forrest.pickChocolate(chocoCaja.pickOne())
    println("Chocolates de Forrest: ${forrest.chocolates}")

    forrest.pickChocolate(chocoCaja.pickOne())
    println("Chocolates de Forrest: ${forrest.chocolates}")

    forrest.pickChocolate(chocoCaja.pickOne())
    println("Chocolates de Forrest: ${forrest.chocolates}")
}