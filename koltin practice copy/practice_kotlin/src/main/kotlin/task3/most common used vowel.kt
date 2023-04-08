package task3

import java.util.*

fun <K, V> getKey(map: Map<K, V>, target: V): Pair<K, V>? {
    for ((key, value) in map)
    {
        if (target == value) {
            return key to value
        }
    }
    return null
}
fun mostVowel(str:String): Pair<Char, Int>? {
    val temp: MutableMap<Char, Int> = mutableMapOf('a' to 0, 'e' to 0, 'i' to 0, 'o' to 0, 'u' to 0)
    for (i in str){
        if( temp.contains(i)){
            temp[i]=temp.getValue(i)+1
        }
    }
    val maxValueInMap: Int = Collections.max(temp.values)

    return getKey(temp,maxValueInMap)

}
fun main() {
    println(mostVowel("sourabooooooh pandey"))
}