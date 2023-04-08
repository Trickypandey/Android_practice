package array

fun main() {
    val arr = intArrayOf(10, 20, 30, 40, 50, 120,1289,546, 140, 200, 230, 650)
    var temp :Int= Int.MAX_VALUE
    for (i in arr) {
        if (i<temp){
            temp=i
        }
    }
    println(temp)
}