package task3

fun findGCD(a: Int, b: Int):Int {
    return if (b == 0) a else findGCD(b, a % b)
}
fun lcm(array: IntArray){
    var lcm = array[0]
    var gcd: Int
    for (i in array.indices){
        gcd = findGCD(array[i], lcm)
        lcm = (lcm*array[i])/gcd
    }
    println(lcm)
//    println(gcd)
}
fun main() {
    val array= intArrayOf(1,2,3,4,5,6,7,8,9,10)
    lcm(array)
}