import classes.Heroe
import com.github.kittinunf.fuel.Fuel

fun main(args: Array<String>) {
    val url = "https://next.json-generator.com/api/json/get/VkOhaUo5B"
    val (request, response, result) = Fuel.get(url).responseObject(Heroe.LecturaHeroeArrayDeserializer())
    val (heroes, err) = result

    //println("Heroes:")
    //heroes?.forEach{ println(it) }


    Thread.sleep(5000)
}