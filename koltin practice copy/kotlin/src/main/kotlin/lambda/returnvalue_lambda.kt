package lambda

val find =fun(num: Int): String{
    if(num % 2==0 && num < 0) {
        return "Number is even and negative"
    }
    else if (num %2 ==0 && num >0){
        return "Number is even and positive"
    }
    else if(num %2 !=0 && num < 0){
        return "Number is odd and negative"
    }
    else {
        return "Number is odd and positive"
    }
}
fun main(args: Array<String>) {
    val result = find(112)
    println(result)
}
