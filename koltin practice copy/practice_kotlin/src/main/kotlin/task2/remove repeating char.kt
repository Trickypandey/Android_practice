package task2

fun removerep(str: String): String {
    var tempstr :String=""
    for (i in str.indices){
        var flag:Int = 0
        for (j in str.indices){
            println("${str[i]}  and ${str[j]} and $i and $j")
            if (str[i]==str[j] && i!=j)
            {

                flag=1
                break
            }
        }
        if (flag==1){

            tempstr=tempstr.plus(str[i])
        }
    }
    return tempstr
}
fun distintEle(str: String):String{
    var list=str.toList()
    var result = list.distinct()
    return result.toString()
}
fun main() {
//    println(distintEle("abbbcddee"))
//    println(removerep("abbbcddee"))
    countReap("abbbcddee")
    countReap("abbbcddee")
}