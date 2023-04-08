fun main(){
    var sum=0
    var number:Int
//    while (i<5){
//        i++
//        if (i==3) {
//            continue
//        }
//        println(i)
//    }
    for (i in 1..6) {
        print("Enter an integer: ")
        number = readLine()!!.toInt()

        if (number <= 0)
            continue
        sum += number
    }
    println("sum = $sum")
}