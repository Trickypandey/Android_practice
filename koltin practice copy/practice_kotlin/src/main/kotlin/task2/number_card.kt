package task2

fun woWIns(you:Array<Int>,opp:Array<Int>):Boolean{
    you.sort()
    opp.sort()
    val youNum=you[you.size-1]*10 + you[you.size-2]
    val oppNum=opp[opp.size-1]*10 +opp[opp.size-2]

    if (youNum>oppNum) return true

    return  false

}
fun main() {
    val youNUm = arrayOf(1, 2, 9,6,9)
    val oppNum = arrayOf(3,4,1,9,7)
    println(woWIns(youNUm,oppNum))
}