fun largestNumber(a: Int, b: Int, c: Int): Int {
    fun largest(a: Int, b: Int): Int {
        if (a > b) return a
        else return b
    }
    return largest(largest(a, b), largest(b, c))
}
fun printLessThanTwo() {
    val list = listOf(1, 2, 3, 4)
    list.forEach(fun(x) {
        if (x < 2) println(x)
        else return
    })
    println("This line will still execute")
}

fun main() {
    println( largestNumber(4,5,6))
    printLessThanTwo()

}