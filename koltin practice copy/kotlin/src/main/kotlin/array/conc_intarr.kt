package array

fun main() {
    val intarr1 = intArrayOf(10, 20, 30, 40, 50)
    val intarr2 = intArrayOf(120, 200, 230, 140, 650)

    var mergearr = intarr1+intarr2
    println(mergearr.contentToString())

    var size = intarr1.size + intarr2.size
    println(size)
    var temp = intArrayOf(size)
    var pos=0
    for (element in intarr1.indices){
        println(element)
        temp[pos] = intarr1[element]
        pos++
    }
    for (element in intarr2){
        println(element)
        temp[pos] = element
        pos++
    }
    println(pos)

    println(temp)
}