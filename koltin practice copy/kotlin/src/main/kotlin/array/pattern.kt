package array
fun factorial(i: Int): Int {
    return if (i == 0) 1 else i * factorial(i - 1)
}
fun main() {
    val row=5
    // right triangle
    for (i in 0..5){
        for (j in 0..i){
            print("*")
        }
        println()
    }
    // reverse right triangle
    for (i in 0..5){
        for (j in 5 downTo i){
            print("*")
        }
        println()
    }
    // triangle
    for (i in 0..row){
        for (j in row-1 downTo i){
            print(" ")
        }
        for (j in 0..i){
            print(" " + factorial(i) / (factorial(i - j) * factorial(j)))
        }
        for (j in 0..i-1){
            print("*")
        }
        println()
    }

    // hollow triangle
    for (i in 0..row){
        for (j in row-1 downTo i){
            print(" ")
        }
        for (j in 0..i){
            if (j == 0)
                print("*")
            else
                print(" ")
        }
        for (j in 0..i-1){
            if (j == i-1)
                print("*")
            else
                print(" ")
        }
        println()
    }
    // daimond
    for (i in 0..row){
        for (j in row-1 downTo i){
            print(" ")
        }
        for (j in 0..i){
            print("*")
        }
        for (j in 0..i-1){
            print("*")
        }
        println()
    }
    for (i in 0..row-1){
        for (j in 0..i){
            print(" ")
        }
        for (j in row-1 downTo i){
            print("*")
        }
        for (j in row-2 downTo i){
            print("*")
        }
        println()
    }

}