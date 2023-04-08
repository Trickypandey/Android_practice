package task3
fun inclusiveArray1(i:Int,j:Int){
    val array= mutableListOf<Int>()
    for (n in i..j){
        array.add(n)
    }
    println(array)
}
fun inclusiveArray(i:Int, j:Int, list: ArrayList<Int>):List<Int>{
    if (i==j){
        list.add(i)
        return  list
    }
    list.add(i)
    return inclusiveArray(i+1,j,list)
}
fun main() {
    var array: ArrayList<Int> = ArrayList()
    println(inclusiveArray(10,100,array))
}