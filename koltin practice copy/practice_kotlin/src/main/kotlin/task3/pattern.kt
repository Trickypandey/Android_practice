package task3
fun factorial(i: Int): Int {
    return if (i == 0) 1 else i * factorial(i - 1)
}
fun main() {
    val row=5
    var temp=1
    // RIGHT ANGLE TRIANGLE
    for (i in 1..row){
        for (j in 1..i){
            print(" $temp")
            temp++
        }
        println()
    }
    // triangle
    for (i in 0..row){
        for (j in row-1 downTo i){
            print(" ")
        }
        for (j in 0 until  i){
            print("*")
        }
        for (j in 0 until i){
            print("*")
        }
        println()
    }
    // PASCAL TRIANGLE
    // triangle
    for (i in 0..row){
        for (j in row-1 downTo i){
            print(" ")
        }
        for (j in 0..i){
            print(" " + factorial(i) / (factorial(i - j) * factorial(j)))
        }
//        for (j in 0..i-1){
//            print("*")
//        }
        println()
    }
    // daimond
    for (i in 0..row){
        for (j in row-1 downTo i){
            print("  ")
        }
        for (j in 0..i){
            print(" *")
        }
        for (j in 0 until i){
            print(" *")
        }
        println()
    }
    for (i in 0 until row){
        for (j in 0..i){
            print("  ")
        }
        for (j in row-1 downTo i){
            print(" *")
        }
        for (j in row-2 downTo i){
            print(" *")
        }
        println()
    }
}