package classes

class ForrestGump (
        var chocolates: ArrayList<Chocolate> = ArrayList()
) {
    fun pickChocolate(chocolate: Chocolate?) {
        if (chocolate != null) {
            chocolates.add(chocolate)
        }
    }
}