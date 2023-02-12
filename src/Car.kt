data class Car(val model: String, val color: String, val numberOfCar: String, val owner: Owner) {
    override fun toString(): String {
        return "model: '$model', color: '$color', number: '$numberOfCar'"
    }
}