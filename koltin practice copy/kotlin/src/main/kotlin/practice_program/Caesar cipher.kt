package practice_program

fun Caesar_cipher(str:String,key:Int):String{
    var temp:String=""
    println(str)
    for (i in str.indices){
//        println(i)
        var pos=str[i].toInt()
        println(pos)
        var encptpos=(pos+key)%key
        var enpchar=encptpos.toChar()
        println("$encptpos  and $enpchar")
//        temp=temp+enpchar
    }
    return temp
}

fun main() {
    var a="Tricky pandey"

    println(Caesar_cipher(a,1))
}