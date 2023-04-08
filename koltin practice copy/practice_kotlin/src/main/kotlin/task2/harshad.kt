package task2
fun sum(number: Int): Int {
    var num =number
    var sum:Int=0
    while (num%10!=0 || num/10>0){
        val temp=num%10
        sum+=temp
        num=num/10
    }
    return sum
}
fun isHarsad(num:Int): Boolean {
    if (num% sum(num)==0){
        return true
    }
    return false
}
fun main() {
//    println(isHarsad(75))
//    println(isHarsad(171))
    println(sum(10))
}