class Manager {

    fun addCarToPark(input: String) {
        val arrayList = input.split(" ")
        val owner = Owner(arrayList[4], arrayList[5])
        val car = Car(arrayList[1], arrayList[2], arrayList[3], owner)

        if(arrayList.size == 6){
            val freePlace = Parking.findFreePlace()
            Parking.places[freePlace] = car

            println("Машина ${car.model} с номером ${car.numberOfCar} припаркована на место ${freePlace}")

            Parking.placesAllStats += 1
        } else {
            println("Неверный формат данных! Попробуйте еще раз")
        }
    }

    fun returnCar(input: String) {
        val listWord = input.split(" ")
        for((key, value) in Parking.places){
            if(value != null){
                if(listWord[1] == value.numberOfCar && listWord[2] == value.owner.firstName && listWord[3] == value.owner.secondName) {
                    println("Авто возвращено владельцу ${value.owner.firstName} ${value.owner.secondName}. Теперь место $key - свободно")
                    Parking.places[key] = null
                    break
                } else {
                    println("Похоже ваши данные не совпадают с данными владельца авто. Пожалуйста, повторите попытку!")
                    break
                }
            }
        }
    }

    fun parkInfoByCar(input: String) {
        val arrayList = input.split(" ")
        for((key, value) in Parking.places){
            if(value != null){
                if(arrayList[1] == value.numberOfCar){
                    println("Автомобиль с номером ${arrayList[1]} припаркован на месте $key")
                    break
                }
            }
        }
    }

     fun parkInfoByPlace(input: String) {
        val arrayList = input.split(" ")
        for((key, value) in Parking.places){
            if(value != null){
                if(arrayList[1] == key){
                    println("Данные авто припаркованном на $key месте: ${value}")
                    break
                }
            }
        }
    }

    fun getParkStats() {
        for((key, value) in Parking.places){
            if(value != null) {
                println("$key - $value")
            } else {
                println("$key - FREE")
            }
        }
    }

    fun getAllParkStats() {
        println("За все время работы команды было припарковано ${Parking.placesAllStats} автомобилей")
    }
}

object Hint {
    const val GREETINGS = "Welcome to the \"Car parking program\""
    const val HELP = "- Доступные команды - \n/start - запуск программы, \n/end - завершение программы" +
            "\n/park - паркова авто на свободное место\n/return - возврат авто владельцу по гос. номеру и данных владельца" +
            "\n/park_info_by_car - выводит место припаркованного авто\n/par_info_by_place - выводит информацию об авто по номеру парковочного места" +
            "\n/park_stats - показывает загруженность парковки\n/park_all_stats - показывает общее кол-во парковки авто"
    const val ERROR = "The program cannot process the request... Call the '/help' command"
    const val COMPLETION = "Thank you for using our program\nWe strive to make our product better and more convenient for users"
}
