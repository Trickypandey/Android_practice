package task2

import kotlin.math.max

fun findDiff(a:Int, b:Int):Int{
    return max(a-b,b-a)
}
fun largNum(array: Array<Int>):Int{
    array.sort()
    var max =0
    for (i in array.indices){
        if (i==array.size-1) {
            break
        }
        val j=i+1
        max = max(max, findDiff(array[i],array[j]))
    }
    return max
}
fun main() {
    val num = arrayOf(9,4,26,26,0,0,5,20,6,25,5)
    val num1 = arrayOf(14,13,7,1,4,12,3,7,12,11,5,7)
    val num2 = arrayOf(13,3,8,5,5,2,13,6,14,2,11,4,10,8,1,9)
    println(largNum(num))
    println(largNum(num1))
    println(largNum(num2))
}