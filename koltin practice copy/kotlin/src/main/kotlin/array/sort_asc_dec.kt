package array

fun main() {
    val intarr1 = intArrayOf(10, 20, 30, 40, 50)
    val intarr2 = intArrayOf(120, 200, 230, 140, 650)
    val  intArrayasc = intarr1+intarr2
    val intArraydsc = intarr1+intarr2


    var temp:Int
    for (i in intArrayasc.indices) {
        for (j in i + 1 until intArrayasc.size) {
            if (intArrayasc[i] > intArrayasc[j]) {
                temp = intArrayasc[i]
                intArrayasc[i] = intArrayasc[j]
                intArrayasc[j] = temp
            }
        }
    }
    for (i in intArraydsc.indices) {
        for (j in i + 1 until intArraydsc.size) {
            if (intArraydsc[i] < intArraydsc[j]) {
                temp = intArraydsc[i]
                intArraydsc[i] = intArraydsc[j]
                intArraydsc[j] = temp
            }
        }
    }

    println(intArrayasc.contentToString())
    println(intArraydsc.contentToString())
}