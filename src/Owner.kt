data class Owner(val firstName: String, val secondName: String) {
    override fun toString(): String {
        return "Owner(firstName='$firstName', secondName='$secondName')"
    }
}