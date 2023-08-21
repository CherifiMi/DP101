import java.lang.RuntimeException

fun main() {

    val email = Mail().message("hellow").title("mito")

    println(email.cc)

}


class Mail {
    var to: List<String> = listOf("")
        private set
    var cc: List<String>? = null
        private set
    var title: String? = ""
        private set
    var message: String? = null
        private set
    var important: Boolean = false
        private set


    fun title(title: String?): Mail {
        this.title = title
        return this
    }

    fun important(important: Boolean): Mail {
        this.important = important
        return this
    }

    fun cc(cc: List<String>?): Mail {
        this.cc = cc
        return this
    }

    fun to(to: List<String>): Mail {
        this.to = to
        return this
    }

    fun message(message: String): Mail {
        this.message = message
        return this
    }
}