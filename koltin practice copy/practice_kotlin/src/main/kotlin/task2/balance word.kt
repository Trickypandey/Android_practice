package task2
fun getascii(chr:Char):Int{
    return chr.toInt()-96
}
fun Sum(str: String,i:Int,j:Int): Int {
    var sum:Int=0
    var temp=i
    while (temp<j){
        sum+= getascii(str[temp])
//        println("$temp and sum=$sum")
        temp++
    }
    return sum
}
fun balance(str: String): Boolean {
    // zips
    //brake
    var rightSum:Int
    var leftSum:Int

    val mid = str.length/2
//    println(mid)
    if (str.length%2==0){
        leftSum= Sum(str,0,mid)
        rightSum = Sum(str,mid,str.length)
    }
    else{
        leftSum= Sum(str,0,mid)
        rightSum = Sum(str,mid+1,str.length)
    }
    println("leftsum=$leftSum and right = $rightSum ")

    return leftSum==rightSum

}
fun main() {
    println(balance("zips"))
    println(balance("brake"))
    println(balance("malayalam"))
}