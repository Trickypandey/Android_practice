package task3

fun printGrid(row:Int,col:Int){
        var temp =1
    for (i in 0 until col){
        for (j in 0 until row){
            print("${temp+i},")
            temp++
        }
        println()
    }

}
fun main() {
    printGrid(5,6)
}