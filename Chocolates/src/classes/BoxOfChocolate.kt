package classes

import java.util.*

class BoxOfChocolate <Chocolate> (
    private var chocolates: ArrayList<Chocolate>
) {
    fun pickOne(): Chocolate? {
        if (chocolates.size > 0) {
            chocolates.removeAt(Random().nextInt(chocolates.size))
            return chocolates[Random().nextInt(chocolates.size)]
        }
        return null
    }
}