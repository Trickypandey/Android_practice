package class_obj

class Automobile(val name: String, val tyres: Int, val maxSeating: Int)
{
    init {
        println("Init Block 1")
    }

    fun drive() {}

    init {
        println("Init Block 2")
    }

    fun applyBrakes() {}
}
fun main() {
    var car = Automobile("Car", 4, 4)
//    var car2 = Automobile("Car2")
}