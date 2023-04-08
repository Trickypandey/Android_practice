package task3

fun convertTime(str:String){
    if (str.contains("am")||str.contains("pm"))
    {
        var list = mutableListOf<String>()
        str.split(":"," ").forEach {
            list.add(it)
        }
        if (list[0]=="12" && list[2]=="am"){
            println("00:${list[1]}")
        }
        else if (list[0].toInt() in 0..11 && list[2]=="am"){
            println("${list[0]}:${list[1]}")
        }
        else{
            println("${list[0].toInt()+12}:${list[1]}")
        }
    }
    else{
        var list = mutableListOf<String>()
        str.split(":"," ").forEach {
            list.add(it)
        }
        if (list[0].toInt() in 0..12){
            println("${list[0]} : ${list[1]} am")
        }
        else{
            println("${list[0]} : ${list[1]} pm")
        }
    }
}
fun main() {
    convertTime("6:00 am")
    convertTime("12:15 am")
    convertTime("00:15 am")
    convertTime("3:15 pm")
    convertTime("5:00")
    convertTime("13:12")
}

