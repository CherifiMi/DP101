fun main() {

    cellPhone(
        charger(
            usPowerOutlit().toEUPlug()
        ).toUsbTypeC()
    )

}

interface USPlug {
    val hasPower: Int
}

interface EUPlug {
    val hasPower: String
}

interface USBMine {
    val hasPower: POWER
}

enum class POWER { TRUE, FALSE }

interface UsbTypeC {
    val hasPower: Boolean
}


fun cellPhone(chargeCable: UsbTypeC) {
    if (chargeCable.hasPower) {
        println("got power")
    } else {
        println("no power")
    }
}

fun usPowerOutlit(): USPlug {
    return object : USPlug {
        override val hasPower: Int = 1
    }
}

fun charger(plug: EUPlug): USBMine {
    return object : USBMine {
        override val hasPower: POWER = POWER.valueOf(plug.hasPower)
    }
}


fun USBMine.toUsbTypeC(): UsbTypeC {
    return object : UsbTypeC {
        override val hasPower: Boolean = this@toUsbTypeC.hasPower == POWER.TRUE
    }
}

fun USPlug.toEUPlug() : EUPlug{
    return object : EUPlug{
        override val hasPower: String = if (this@toEUPlug.hasPower == 1) "TRUE" else "FALSE"
    }
}