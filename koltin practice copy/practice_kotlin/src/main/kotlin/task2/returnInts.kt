package task2
fun returnInt(arr:List<Any>):List<Int>{
    val temp = mutableListOf<Int>()
    for (i in arr){
        if (i is Int){
            temp.add(i)
        }
    }
    return temp
}
fun main() {
    var listA = listOf<Any>(9,2,"car","lion",16)
    println(returnInt(listA))
}