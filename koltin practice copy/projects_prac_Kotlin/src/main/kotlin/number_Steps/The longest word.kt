package number_Steps

import kotlin.math.max

fun longestWord(str:String):Int{
    var max=0
    var tempMax=0

    for (chr in str.indices){

        if (str[chr]==' ' ){
            if (str.length==chr+1){
                max= max(max,tempMax+1)
                break
            }
            max= max(max,tempMax)
            tempMax=0
            continue
        }else{
            tempMax++
        }
    }
    return max
}
fun main() {
    println(longestWord("I love Codecademy"))
}