import java.lang.RuntimeException

fun main() {

    val email = Mail2(listOf("mito@gmail")).message("hellow").title("mito")

    println(email)

}

data class Mail2(
    var to: List<String> = listOf(""),
    private var _cc: List<String>? = null,
    private var _title: String? = "",
    private var _message: String? = null,
    private var _important: Boolean = false,
) {
    val cc: List<String>? get() = _cc
    val title: String? get() = _title
    val message: String? get() = _message
    val important: Boolean get() = _important

    fun title(title: String?) = apply {
        _title = title
    }

    fun message(message: String?) = apply {
        _message = message
    }
}
