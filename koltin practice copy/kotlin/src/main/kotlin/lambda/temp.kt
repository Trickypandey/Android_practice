package lambda

val big = { x: Int, y: Int -> if (x>y) x else y  }
fun main() {
    val s1= big(3,4)
    println(s1)
}