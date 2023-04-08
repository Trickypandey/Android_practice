package task3

import kotlin.math.pow

fun count2(n:Int):Int{
    if (n/10 == 0)
        return 1
    return 1 + task1.count2(n / 10)
}
fun isDisarium(n:Int): Boolean {
    var temp=n
    var l= count2(n)
    var a: Int
    var sum=0
    while (temp > 0) {
        a = temp % 10
        sum += a.toDouble().pow(l.toDouble()).toInt()
        l--
        temp /= 10
    }
    return sum== n
}
fun main() {
    println(isDisarium(8))
}