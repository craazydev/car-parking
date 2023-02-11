import Command.*

var parkingOpen: Boolean = true

fun main() {
    printlnHint(Hint.BEFORE_USING)

    while (parkingOpen){
        sendRequest(readLine().toString())
    }
}

fun sendRequest(command: String){
    when(command){
        START.command -> {
            printlnHint(Hint.GREETINGS)
        }

        HELP.command -> {
            printlnHint(Hint.HELP)
        }

        END.command -> {
            printlnHint(Hint.COMPLETION)

            parkingOpen = false
        }

        else -> {
            printlnHint(Hint.ERROR)
        }
    }
}

fun printlnHint(hint: String) {
    println(hint)
}


enum class Command(val command: String) {
    START("/start"),
    HELP("/help"),
    END("/end")
}

object Hint {
    const val BEFORE_USING = "Please enter command => /start, /help, /end"
    const val GREETINGS = "Welcome to the \"Car parking program\""
    const val HELP = "Available commands /start, /end"
    const val ERROR = "The program cannot process the request... Call the '/help' command"
    const val COMPLETION = "Thank you for using our program\nWe strive to make our product better and more convenient for users"
}