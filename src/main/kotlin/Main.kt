import java.lang.RuntimeException

fun main() {

    val email = MailBuilder().message("hellow").title("mito").build()

    println(email)

}


class MailBuilder {
    private var to: List<String> = listOf("")
    private var cc: List<String>? = null
    private var title: String? = ""
    private var message: String? = null
    private var important: Boolean = false

    class Mail internal constructor(
        val to: List<String>,
        val cc: List<String>?,
        val title: String?,
        val message: String?,
        val important: Boolean,
    )

    fun build(): Mail {
        if (to.isEmpty()){
            throw RuntimeException("to is empty")
        }
        return Mail(to, cc, title, message, important)
    }

    fun title(title: String?): MailBuilder {
        this.title = title
        return this
    }
    fun important(important: Boolean): MailBuilder {
        this.important = important
        return this
    }
    fun cc(cc: List<String>?): MailBuilder {
        this.cc = cc
        return this
    }
    fun to(to: List<String>): MailBuilder {
        this.to = to
        return this
    }
    fun message(message: String): MailBuilder {
        this.message = message
        return this
    }

}