package task1

fun nextEdge(a:Int, b:Int):Int{
    return (a+b)-1
}
fun main() {
    println(nextEdge(8,10))
    println(nextEdge(5,7))
    println(nextEdge(9,2))
}