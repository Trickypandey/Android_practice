package array

import java.util.*

fun main() {
    val input= Scanner(System.`in`)
    val rows = 2
    val cols = 2
    var even:Int =0
    var odd:Int=0

    val matrixA     = Array(rows) { IntArray(cols) }
    println("Enter the Elements of First Matrix ($rows X $cols} ): ")
    for(i in matrixA.indices){
        for(j in matrixA[i].indices){
            print("matrixA[$i][$j]: ")
            matrixA[i][j]=input.nextInt()
            if (matrixA[i][j]%2==0) even++ else odd++
        }
    }
    println("there are $even even number and $odd odd number")
}