package array

import java.util.*
fun main() {
    val input = Scanner(System.`in`)
    println("enter the size of the array")
    var size =input.nextInt()
    var charArr = CharArray(size)

    // input of array
    println("Enter Char Arrays Elements:")
    for (i in charArr.indices) {
        print("charArray[$i] : ")
        charArr[i] = input.next()[0]
    }
    println("${charArr.contentToString()}")
    // converting char array to string
    var string = String(charArr)
    println(string)


}