object Parking {
    val places: MutableMap<String, Car?> = mutableMapOf()

    var placesAllStats = 0

    fun carParkingInit() {
        for(i in 1 until 21){
            places["P$i"] = null
        }
    }

    fun findFreePlace(): String {
        var freeKey = ""
        for((key, value) in places){
            if(value == null){
                freeKey = key
                break
            }
        }
        return freeKey
    }
}