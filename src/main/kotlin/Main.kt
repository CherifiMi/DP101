fun main() {

}

interface USPlug{
    val hasPower: Int
}

interface EUPlug{
    val hasPower: Boolean
}

interface USBMine{
    val hasPower: POWER
}
enum class POWER { TRUE,FALSE }

interface UsbTypeC{
    val hasPower: Boolean
}



fun cellPhone(chargeCable: UsbTypeC){
    if (chargeCable.hasPower){
        println("got power")
    }else{
        println("no power")
    }
}