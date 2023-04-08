import  java.util.Scanner
fun main(){
    val reader=Scanner(System.`in`)
    println("enter the intiger values for a and b")
    print("a =")
    val a:Int =reader.nextInt()
    print("b =")
    val b:Int = readln().toInt()
    println("select one from +,-,*,/")
    val opearator= readln()

    when(opearator){
        "+"-> println(a+b)
        "-"-> println(a-b)
        "*"-> println(a*b)
        "/"-> println(a/b)
        else-> println("Invalid operator $opearator")
    }
//    when(age){
//        in 1.. 10-> println("your age us between 1 to 10")
//        in 11.. 20-> println("your age us between 11 to 20")
//        in 21.. 30-> println("your age us between 21 to 30")
//        in 31.. 40-> println("your age us between 31 to 40")
//
//    }
}