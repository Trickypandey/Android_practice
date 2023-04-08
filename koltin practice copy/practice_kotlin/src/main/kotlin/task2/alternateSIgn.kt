package task2
fun alternateSign(arr:Array<Int>):Boolean{
    for(i in arr){
        if (i==0) return false
    }
    for (i in 1..arr.lastIndex){
        if (arr[i-1]>0 && arr[i]>0)
            return false
        else if (arr[i-1]<0 && arr[i]<0)
            return false
    }
    return true
}
fun main() {
    val num = arrayOf<Int>(1,-2,3,-4,5,-6)
    val num1 = arrayOf<Int>(1,2,3,-4,5,6)
    println(alternateSign(num))
    println(alternateSign(num1))

}