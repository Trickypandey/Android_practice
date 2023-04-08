fun main(){
    var sum: Int =0
    var input:Int

    do {
        print("enter a value ")
        input= readln().toInt()
        sum+=input
    }while (input!=0)
    print(sum)
}