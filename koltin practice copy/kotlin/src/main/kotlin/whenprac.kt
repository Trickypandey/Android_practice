import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    print("ENTER THE SIZE OF THE ROW: ")
    var row = sc.nextInt()
    println()
    print("ENTER THE SIZE OF COLUMN: ")
    val column = sc.nextInt()
    println()
    var a = Array(row){IntArray(column)}
    for(i in 0 until row){
        when (i) {
            0 -> {
                println("----------${i+1} st ROW'S DATA----------")
            }
            1 -> {
                println("----------${i+1} nd ROW'S DATA----------")
            }
            2 -> {
                println("----------${i+1} rd ROW'S DATA----------")
            }
            else -> {
                println("----------${i+1} th ROW'S DATA----------")
            }
        }
        for(j in 0 until column)
        {
            print("ENTER ${j+1} COLUMN'S DATA: ")
            var data:Int = sc.nextInt()
            a[i][j]=data;
        }
        println()
    }
    println("COLLECTION OF DATA IS COMPLETED")
    for(i in 0 until row){
        for(j in 0 until column){
            print(a[i][j])
            print(" ")
        }
        println()
    }


}