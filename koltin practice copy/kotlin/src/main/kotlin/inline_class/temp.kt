package inline_class

inline class Name(val s: String) {
    val length: Int
        get() = s.length
    fun greet() {
        println("Hello, $s")
    }
}
data class Item(val id: Int, val price: RupeePrice, val qty: Int)
@JvmInline
value class RupeePrice constructor(val price: Float){
    fun toDollars(): Float = price * 71.62f
}
fun main() {
    val name = Name("Kotlin")
    name.greet()
    println(name.length)
    val dollar=RupeePrice(100f)
    val doll=RupeePrice(100f)
    val p1 = Item(1,dollar,2)
    println(dollar.hashCode())
    println(doll.hashCode())
}
