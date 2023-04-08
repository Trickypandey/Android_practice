package lambda

import kotlin.math.ln

fun main() {
    val sampleLambda:(String,String,String)->Unit = {
        fname,mname,lname->
        println("$fname $mname $lname")
    }

    val sum1 = { a: Int, b: Int -> a + b }

    val sum2:(Int,Int)-> Int  = { a , b -> a + b}

    val result = sum1(1,2)
    val r2=sum2(5,6)
    sampleLambda("Sourabh","pandey","anil")
    println("$result $r2")
}









