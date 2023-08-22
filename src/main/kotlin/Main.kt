import java.lang.RuntimeException

fun main() {

    val starTruk = DefultStarTrakRepo()
    val withLog = StarShipLog(starTruk)
    val withCheck = StarShipCheck(starTruk)
    val withLogAndCheck = StarShipCheck(withLog)


    println(withLogAndCheck["USS"])

}
interface StarTrekRepo{
    operator fun get(shipName: String): String
    operator fun set(shipName: String, captinName: String)
}

class DefultStarTrakRepo: StarTrekRepo{

    private val starShip = mutableMapOf("USS" to "Jean")

    override fun get(shipName: String): String {
        return starShip[shipName] ?: "IDK"
    }

    override fun set(shipName: String, captinName: String) {
        starShip[shipName] = captinName
    }
}


class StarShipLog(private val repo: StarTrekRepo): StarTrekRepo by repo{
    override fun get(shipName: String): String {
        println(shipName)
        return repo[shipName]
    }
}

class StarShipCheck(private val repo: StarTrekRepo): StarTrekRepo by repo{
    override fun get(shipName: String): String {
        if (shipName.toList().size>15){
            throw RuntimeException("tow long")
        }
        return repo[shipName]
    }
}