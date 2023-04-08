package practice_program

fun step_limit(i:Int,limit:Int,step:Int):Int {
    if (i>limit){
        return 0
    }
    println(i+step)
    return step_limit(i+step,limit, step)
}
fun main() {
    step_limit(0,10,2)
}