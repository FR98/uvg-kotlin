package classes

import java.util.*

class BoxOfChocolate <Chocolate> (
    private var chocolates: ArrayList<Chocolate>
) {
    fun pickOne(): Chocolate? {
        if (chocolates.size > 0) {
            val randomID = Random().nextInt((chocolates.size-1))
            return chocolates.removeAt(randomID)
        }
        return null
    }
}