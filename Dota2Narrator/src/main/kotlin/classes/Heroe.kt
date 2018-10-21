package classes

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class Heroe (
        val name: String,
        val id: Int,
        val localized_name: String,
        val type: String
){
    //OBTENCION DE HEROES DEL API
    class LecturaHeroeArrayDeserializer: ResponseDeserializable<Array<Heroe>> {
        override fun deserialize(content: String): Array<Heroe>? {
            return Gson().fromJson(content, Array<Heroe>::class.java)
        }
    }
}