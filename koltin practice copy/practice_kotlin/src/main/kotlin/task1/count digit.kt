package task1

var count=0
fun countDigit(a:Int){
    if (a%10==0){
        return
    }
    println(a%10)
    count++
    return countDigit(a /10)

}
fun count2(n:Int):Int{
    if (n/10 == 0)
        return 1
    return 1 + count2(n / 10)
}
fun main() {
    countDigit( 318)
    demo(318)
    println(count2(1233333))
}

fun demo(i: Int)
{
    i.toString().length
}
