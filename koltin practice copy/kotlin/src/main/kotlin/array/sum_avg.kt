package array

import java.util.*
fun main() {
    val intarr = intArrayOf(10, 20, 30, 40, 50)
    val size = intarr.size
    var average :Float
    var sum:Int=0

    for (i in 0..size-1){
        sum+=intarr[i]
    }
    println(sum)
    average = (sum/size).toFloat()
    println(average)
}