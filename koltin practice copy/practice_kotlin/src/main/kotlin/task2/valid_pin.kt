package task2

fun validPin(pass : Int):Boolean{
    if ((count2(pass)==4 || count2(pass)==6)&& checkWhiteSpace(pass))
    {
        return true
    }
    return false
}
fun checkInt(num:Int):Boolean{
    val arr= arrayOf(1,2,3,4,5,6,7,8,9,0)
    for (i in arr){
        for (j in getDigit(num)){
            if (j!=i){
                return false
            }
        }
    }
    return true
}
fun count2(n:Int):Int{
    if (n/10 == 0)
        return 1
    return 1 + count2(n / 10)
}
fun getDigit(n:Int):List<Int>{
    var num=n
    val numlist = ArrayList<Int>()
    while (num!=0){
        var temp:Int
        (n%10).also { temp = it }
        num /= 10
        numlist.add(temp)
    }
    return numlist
}
fun checkWhiteSpace(num: Int):Boolean{
    for (i in getDigit(num)){
        if (i.toChar() != ' '){
            return true
        }
    }
    return false
}
fun main() {
    println(validPin(123456))
}