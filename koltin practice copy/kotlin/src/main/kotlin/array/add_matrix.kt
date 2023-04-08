package array

import java.util.Scanner

fun main() {
    val input=Scanner(System.`in`)
    val rows = 2
    val cols = 2

    //Create Array

    val matrixA     = Array(rows) { IntArray(cols) }
    val matrixB     = Array(rows) { IntArray(cols) }
    val matrixSum   = Array(rows) { IntArray(cols) }

    //Input MatrixA

    println("Enter the Elements of First Matrix ($rows X $cols} ): ")
    for(i in matrixA.indices){
        for(j in matrixA[i].indices){
            print("matrixA[$i][$j]: ")
            matrixA[i][j]=input.nextInt()
        }
    }

    //Input MatrixB

    println("Enter the Elements of second Matrix ($rows X $cols} ): ")
    for(i in matrixB.indices){
        for(j in matrixB[i].indices){
            print("matrixB[$i][$j]: ")
            matrixB[i][j]=input.nextInt()
        }
    }

    // Adding Matrix

    for (i in matrixSum.indices){
        for (j in matrixSum.indices){
            matrixSum[i][j]=matrixA[i][j]+matrixB[i][j]
        }
    }

    // printing sum

    println("Sum of the matrix")
    for (i in matrixSum.indices){
        println(matrixSum[i].contentToString())
    }
}