package object_exp

open class vehicle{
    open fun run(){
        println("runs on fuel")
    }
}

fun main() {
    val temp = object:vehicle() {
        override fun run() {
            println("runs on fuel")
        }
    }
    println(temp is vehicle)
    temp.run()
}