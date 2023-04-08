package task3

fun removeleadingtrailing(string: String){
    var temp=string.toCharArray()
    println(string.stripTrailing().stripLeading())
    var str:String=""
    for (i in temp.indices){
        if (temp[i] != '0'){
            str=string.substring(i,string.length-1)
            break
        }
    }
    println(str.stripTrailing())
}
fun main() {
    removeleadingtrailing("00002300.0000")
}