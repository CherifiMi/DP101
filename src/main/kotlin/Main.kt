import java.lang.Exception
import java.lang.RuntimeException

fun main() {

    val notations = listOf(
        "Pe4",
        "Pb6",
        "Pd4",
        "Pg6",
        "Pc3",
        "Pd6",
        "Pe5",
        "Pd5",
        "Bb7",
        "Bd3",
        "Bg7",
        "Nf3",
        "Be3",
        "Nd7",
        "Nd2",
        "Qd6"
    )
    val pieces = mutableListOf<ChessPiece>()
    for (n in notations) {
        pieces.add(createChessPiece(n))
    }
    println(pieces)
}

fun createChessPiece(n: String): ChessPiece {
    val (type, file, rank) = n.toCharArray()

    return when(type){
        'P' -> Pawn(file, rank)
        'Q' -> Queen(file, rank)
        'N' -> Night(file, rank)
        'B' -> Bechup(file, rank)
        else -> throw RuntimeException("UnKnown piece $type")
    }
}

interface ChessPiece {
    val file: Char
    val rank: Char
}


data class Pawn(
    override val file: Char,
    override val rank: Char
) : ChessPiece

data class Bechup(
    override val file: Char,
    override val rank: Char
) : ChessPiece
data class Night(
    override val file: Char,
    override val rank: Char
) : ChessPiece
data class Queen(
    override val file: Char,
    override val rank: Char
) : ChessPiece
