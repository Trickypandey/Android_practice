package class_obj

fun main() {
    val p1 = person(1,"sourabh")
    val p3 = person(3,"sourabh")
    val p2 = person(2,"tricky")

    println(p1)
    println(p2)
    println(p1 == p3 )

}
data class  person(val id : Int,val name :String){

}