fun main() {

}
open class StarTrekRepo{
    private val starShip = mutableMapOf("USS" to "Jean")

    open fun getCaptin(shipName: String): String{
        return starShip[shipName] ?: "IDK"
    }
}