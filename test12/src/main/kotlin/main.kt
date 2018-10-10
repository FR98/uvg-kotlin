import com.github.kittinunf.fuel.Fuel

fun main(args: Array<String>) {
    Fuel.get("http://samuelchavez.com").response{ request, response, result ->
        println(request)
        println(response)
        println(result)
    }

    Thread.sleep(5000)
}