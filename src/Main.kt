import Command.*

var parkingOpen: Boolean = true

var manager: Manager? = null

fun main() {
    Parking.carParkingInit()

    manager = Manager()

    var enteredRequest = ""
    while (parkingOpen){
        println("\nВведите команду:")
        enteredRequest = readLine().toString()

        sendRequest(enteredRequest.split(" ")[0], enteredRequest)
    }
}

fun sendRequest(command: String, allStringCommand: String){
    when(command){
        PARK.command -> {
            manager?.addCarToPark(allStringCommand)
        }

        RETURN.command -> {
            manager?.returnCar(allStringCommand)
        }

        PARK_BY_PLACE.command -> {
            manager?.parkInfoByPlace(allStringCommand)
        }

        PARK_BY_CAR.command -> {
            manager?.parkInfoByCar(allStringCommand)
        }

        PARK_STATS.command -> {
            manager?.getParkStats()
        }

        PARK_ALL_STATS.command -> {
            manager?.getAllParkStats()
        }

        START.command -> {
            println(Hint.GREETINGS)
        }

        HELP.command -> {
            println(Hint.HELP)
        }

        END.command -> {
            println(Hint.COMPLETION)

            parkingOpen = false
        }

        else -> {
            println(Hint.ERROR)
        }
    }
}