package task3
val  upper_case = mutableListOf<Char>()
val  lower_case = mutableListOf<Char>()
val number = mutableListOf<Char>()
val special_char = mutableListOf<Char>()
fun strongPass(pass:String){
    var countUpper =0
    var countlower =0
    var countNumber =0
    var countCHar =0
    var count=0
    if (pass.length<6) count++
    pass.forEach {
        if (upper_case.contains(it)){
            countUpper++
        }
        else if (lower_case.contains(it)){
            countlower++
        }
        else if (number.contains(it)){
            countNumber++
        }
        else if (special_char.contains(it)){
            countCHar++
        }
    }
    if (countlower==0){
        count++
    }
    if (countUpper==0){
        count++
    }
    if (countNumber==0){
        count++
    }
    if (countCHar==0){
        count++
    }
    if (count != 0){
        println(count)
    }
    else{
        println("your password is strong")
    }
}

fun main() {
    for (i in 'A'..'Z'){
        upper_case.add(i)
    }
    for (i in 'a'..'z'){
        lower_case.add(i)
    }
    for (i in '0'..'9'){
        number.add(i)
    }
    special_char.add('!')
    special_char.add('@')
    special_char.add('#')
    special_char.add('$')
    special_char.add('%')
    special_char.add('^')
    special_char.add('&')
    special_char.add('*')
    special_char.add('(')
    special_char.add(')')
    special_char.add('-')
    special_char.add('+')
//    val pattern = "[a-zA-z0-9!@#$%^&*()-+]".toRegex()
    val str ="SOur12@#"
    println(strongPass(str))

}
