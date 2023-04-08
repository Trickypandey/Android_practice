package dataClass
data class person(
    val id :Int,
    val name :String
)
fun main() {
    val p1=person(1,"sourabh")
    println(p1)
}