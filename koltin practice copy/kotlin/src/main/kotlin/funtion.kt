fun main(){
    var sum = add(5,7)
        println(sum)
    println(add())
    var number:Int=21
    if (isEven(number)){
        println("$number is even")
    }
    else
        println("$number is odd")
}
fun add(a:Int=9 , b:Int=90):Int {
    return a+b
}

fun isEven(number:Int):Boolean{
    if((number%2)==0) return true else return false
}