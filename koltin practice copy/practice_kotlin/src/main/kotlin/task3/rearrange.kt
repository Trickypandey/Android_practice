package task3
fun display(map :Map<Int,String>){
    var str =""
    map.forEach{
        str+="${it.value} "
    }
    println(str)
}
fun reArrange(string: String){
    val senmap = mutableMapOf<Int, String>()
    string.split(" ").forEach { it ->
        val word=it
        var key =0
        var value =""
        word.split("").forEach(){
            try{
                if (it.toInt() is Int) {
                    key = it.toInt()

                }
            }catch (e:Exception){
                    value+=it
            }
            if (key!=0) {
                senmap.set(key,value)
            }
        }
    }

    val sortedMap: MutableMap<Int, String> = LinkedHashMap()
    senmap.entries.sortedBy { it.key }.forEach { sortedMap[it.key] = it.value }
    display(sortedMap)


}
fun main() {
    reArrange("name2 i3s s4ourabh m1y")

    reArrange("5ajbfakd afdarfarffargttsd6 name2 i3s s4ourabh m1y")

    reArrange("ar2e m4y n5ame  ho1w y3ou i6s Sourab7h")
}