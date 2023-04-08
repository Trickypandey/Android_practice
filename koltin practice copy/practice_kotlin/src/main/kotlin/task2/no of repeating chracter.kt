package task2
fun countReap(str:String){
    var count :Int=0
    var tempStr:String=""
    distintEle(str).split(",","[","]"," ").forEach {
        tempStr +=it
    }
    for (i in tempStr){

        var temp:Int=0
        for (j in str){
//            println(j)
            if (i == j){
//                println("i=$i and j=$j")
                temp++
            }
        }
        if (temp>1){
            print(i)
            count++
        }
    }
    println(count)
}
fun main() {
countReap("aabbcdeff")
}