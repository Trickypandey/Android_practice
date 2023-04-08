package high_order_funtion

//fun decide(first:String,second:String,charName:(String,String)->String){
//    val temp=make(first,second)
//}
//fun main() {
//    val temp:(String,String)->String ={firstname,secondname->"$firstname is now $secondname"}
//}
fun main() {
    val greeter :(String,String)->String={ name:String,surname:String->"hello $name $surname" }
    println(greeter("Tricky","Pandey"))
}