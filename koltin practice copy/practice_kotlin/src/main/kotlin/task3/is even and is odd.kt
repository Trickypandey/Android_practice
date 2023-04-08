package task3
fun isOdd(n:Int){
    if (n and 1 != 0){
        println("$n is a oDD number")
    }
}
fun isEven(n:Int){
    val pattern="^\\d*[02468]\$".toRegex()
    if(pattern.matches(n.toString()))  {
        println("$n is a even number")
    }
}
fun main() {
    isEven(10)
    isOdd(11)
}