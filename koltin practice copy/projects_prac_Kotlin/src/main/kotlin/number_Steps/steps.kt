package number_Steps
fun step(number: Int,step:Int,ini :Int):Int{
    if (ini>number){
        return 0
    }
    println(ini)
    return step(number,step,ini+step)
}
fun main() {
    step(15,2,0)
}