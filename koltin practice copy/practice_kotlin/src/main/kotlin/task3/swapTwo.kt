package task3
fun swapArray(a: MutableList<Char>) {
    for (i in 0..1 )
    {
        val temp = a[i]
        a[i] = a[i+2]
        a[i+2] = temp
    }
}
fun swapTwo(string: String){
    var start=0
    var end=3
    val time = string.length/4
    var str =""
    while (end<time*4){
        val sub =string.subSequence(start,end+1).toString().toMutableList()
        swapArray(sub)
        sub.forEach{
            str+=it
        }
        start+=4
        end+=4
    }
   println(str)
}
fun main() {
    swapTwo("Sourabhpandey")
    swapTwo("ABCDEFGH")
}