import Parser.Companion.server
import java.lang.RuntimeException

fun main() {

    val portProperty = "port: 8080"
    val environment = "environment: production"

    val server = server(listOf(portProperty, environment))

    println(server.property)

}

interface Property{
    val name: String
    val value: Any
}
interface ServerConfig {
    val property: List<Property>
}

data class IntProperty(
    override val name: String,
    override val value: Int
): Property
data class StringProperty(
    override val name: String,
    override val value: String
): Property

data class ServerConfigImpl(override val property: List<Property>):ServerConfig

class Parser{
    companion object{
        fun property(prop: String): Property{
            val (name, value) = prop.split(":")
            return when(name){
                "port" -> IntProperty(name, value.trim().toInt())
                "environment" -> StringProperty(name, value)
                else ->  throw RuntimeException("unknown prop: $name")
            }
        }
        fun server(propertyString: List<String>): ServerConfig{
            val paresedProperties = mutableListOf<Property>()
            for (p in propertyString){
                paresedProperties += property(p)
            }
            return ServerConfigImpl(paresedProperties)
        }
    }
}