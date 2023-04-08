package task1

fun search(array: Array<Int>, tar :Int){
    var flag=false
    for (i in array){
        if (i==tar) flag=true

    }

    if (flag) println("Boom!")
    else println("there is no $tar  in array")
}
fun main() {
    var arr = arrayOf(1,2,3,4,5,6,7)
    search(arr,5)
    search(arr,9)
}
