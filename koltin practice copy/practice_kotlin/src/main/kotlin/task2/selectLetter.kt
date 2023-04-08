package task2
fun join(idx:Int,str:String): Char {
    return str[idx]
}
fun selectLetter(str: String,str2:String){
    var temp:String=""
    for (i in str2.indices){
        if (str2[i].isUpperCase() && i<str.length){
            temp+=str[i]
        }
    }
    for (i in str.indices){
        if (str[i].isUpperCase()&&i<str2.length){
            temp+=str2[i]
        }
    }
    println(temp)
}
fun main() {
    selectLetter("heLLo","lpGUHJJ")
    selectLetter("12345678","XxXxXxX")


}