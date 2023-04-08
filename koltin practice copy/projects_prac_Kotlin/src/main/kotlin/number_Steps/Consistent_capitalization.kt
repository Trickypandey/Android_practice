package number_Steps
fun toCamelCase(str: String):String{
    var temp=""
    var pre:Char?=null
    for (chr in str){

        if(chr==' '||chr=='_'){
            pre=chr
            continue
        }
        if (pre==chr) break
        if (pre==' '||pre=='_' ){
            temp+=chr.uppercaseChar()
            pre=null
            continue
        }
        temp+=chr
    }
    return temp
}
fun toSnakeCase(str: String):String{
    var temp=""
    val underScore='_'
    var pre:Char?=null
    for (chr in str){
        if (pre==chr) continue
        if (chr==' '){
            pre=' '
            temp+=underScore
            continue
        }
        temp+=chr
    }
    println(temp)
    return temp
}

fun change(str :String,case:String):String{
    return when(case){
        "u"-> str.toUpperCase()
        "l"-> str.toLowerCase()
        "c"-> toCamelCase(str)
        "s"-> toSnakeCase(str)
        else->{
            "enter valid input"
        }
    }
}
fun main() {
//    println(change("Tricky","u"))
    println(change("Tricky     pandey","s"))
}