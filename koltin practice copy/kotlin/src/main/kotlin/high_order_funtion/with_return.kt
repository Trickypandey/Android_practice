package high_order_funtion
var temp={a:Int,b:Int->a+b}
fun highorder(a:Int,c:Int,d:Int,b:(Int,Int)->Int):Int{
    val result = d+b(a,c)
    return  result
}

fun main() {
    println(highorder(1,2,3, temp))
}