import java.lang.RuntimeException

fun main() {

}
open class StarTrekRepo{
    private val starShip = mutableMapOf("USS" to "Jean")

    open fun getCaptin(shipName: String): String{
        return starShip[shipName] ?: "IDK"
    }
    open fun addCaptin(shipName: String, captinName: String){
        starShip[shipName] = captinName
    }

}

class StarShipLog: StarTrekRepo(){
    override fun getCaptin(shipName: String): String {
        return super.getCaptin(shipName)
        println(shipName)
    }

    override fun addCaptin(shipName: String, captinName: String) {
        super.addCaptin(shipName, captinName)
        println(shipName + captinName)
    }
}class StarShipCheck: StarTrekRepo(){
    override fun getCaptin(shipName: String): String {
        if (shipName.toList().size>15){
            throw RuntimeException("tow long")
        }
        return super.getCaptin(shipName)
    }

    override fun addCaptin(shipName: String, captinName: String) {
        super.addCaptin(shipName, captinName)
        println(shipName + captinName)
    }
}