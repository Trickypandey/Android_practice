package task2
fun addStrnums(a:String="0",b:String="0"): Int {
    try{
        var num1 = a.toInt()
        var num2 = b.toInt()
        if (num1 is Int && num2 is Int && num2 >= 0 && num1 >= 0 ) {
            return num1 + num2
        }
        else{
            println("enter a non negative number")
        }
    }
    catch (e:Exception){
        println("Not an integer")
    }
    return -1
}
fun main() {
    println(addStrnums("1000","asdfadasd"))
}