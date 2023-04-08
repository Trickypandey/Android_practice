package class_obj


// regular function definition
fun add(a: Int, b: Int): Int{
    var sum = a + b
    return sum
}
// higher-order function definition
fun higherfunc(addfunc:(Int,Int)-> Int){

    var result = addfunc(3,6)
    print("The sum of two numbers is: $result")
}
fun main(args: Array<String>) {
    // higher order funtion
    higherfunc(::add)
}