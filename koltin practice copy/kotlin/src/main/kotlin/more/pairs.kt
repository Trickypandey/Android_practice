package more

fun main() {
    val intro = "name" to "Sourabh"
    val temp = ("name" to "sourabh") to ("how are you" to "Fine")
    val temp2 = "name" to "sourabh" to "age" to "22"

    println(temp.toString())
    println(temp.toList())

    val (name,greeting)=temp
    println("$name and $greeting")


    fun giveme():Pair<String,String>{
        return "name" to "sourabh"
    }
    val (a,b)=giveme()
    println(a)
    println(b)
}