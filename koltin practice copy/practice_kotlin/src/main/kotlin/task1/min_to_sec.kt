package task1

fun minTosec(min:Int):Int{
    return min*60
}
fun secTomin(sec:Int):Float{
    return sec/60F
}
fun main() {
    println(minTosec(60))
    println(secTomin(60))
}