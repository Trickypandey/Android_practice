package task2

fun countDig(n: Long): Int {

    val str = n.toString()
    return str.length
}
//fun doubleOdd(num: Long){
//    var temp= num.toString()
//    var result= mutableListOf<Int>()
//    for (i in temp.indices){
//        if (i%2!=0){
//            println(temp[i])
//            if (count2(temp[i].toInt()*2)==2){
//            }else{
//                result.add(temp[i].toInt())
//
//            }
//        }
//        else{
//            result.add(temp[i].toInt())
//        }
//    }
//}
fun doubleOdd(result: MutableList<Int>): MutableList<Int> {
    for (i in result.indices){
       if (i%2 == 0){
           result[i] *=2
//           println(result)
           if (task1.count2(result[i])==2){
               result[i]= sum(result[i])
           }
       }
    }
    return result
}
fun longTOArray(a:Long): MutableList<Int> {
    var a=a
    var result= mutableListOf<Int>()
    while (a%10 !=0L || a!=0L){
        var rem = a%10
        result.add(rem.toInt())
        a /= 10L
    }
    doubleOdd(result)
    return result
}
fun validateCard(num: Long): Boolean {
    if (countDig(num)  in 14..19){
        val checkDIgit=(num%10).toInt()
        var temp = longTOArray(num/10)
        var result =10-temp.sum()%10
        return checkDIgit==result
    }
    else{
        return false
    }
}
fun main() {
    println(validateCard(1234567890123456))
    println(validateCard(1234567890123452))
}
