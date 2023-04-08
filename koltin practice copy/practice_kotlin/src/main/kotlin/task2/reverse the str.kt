package task2
fun strRev(str: String): String {
    var temp:String=""
    if (str.length%2!=0){
        for (i in str.length-1 downTo  0){
            temp=temp+str[i]
        }
    }
    return temp
}
fun main() {
    println(strRev("trickyp sdfsdf dfdfasdf asdfasdf "))
}