import java.lang.RuntimeException

fun main() {

    val repo = DefultStarTrakRepo()
    val repo2 = StarShipLog(repo)
    val repo3 = StarShipCheck(repo2)

    println( repo3.getCaptin("USS") )
}
interface StarTrekRepo{
    fun getCaptin(shipName: String): String
    fun addCaptin(shipName: String, captinName: String)
}

class DefultStarTrakRepo: StarTrekRepo{

    private val starShip = mutableMapOf("USS" to "Jean")

    override fun getCaptin(shipName: String): String{
        return starShip[shipName] ?: "IDK"
    }
    override fun addCaptin(shipName: String, captinName: String){
        starShip[shipName] = captinName
    }
}


class StarShipLog(private val repo: StarTrekRepo): StarTrekRepo by repo{
    override fun getCaptin(shipName: String): String {
        println(shipName)
        return repo.getCaptin(shipName)
    }
}

class StarShipCheck(private val repo: StarTrekRepo): StarTrekRepo by repo{
    override fun getCaptin(shipName: String): String {
        if (shipName.toList().size>15){
            throw RuntimeException("tow long")
        }
        return repo.getCaptin(shipName)
    }
}