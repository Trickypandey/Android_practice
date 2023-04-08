package list

fun main() {
    val theMap = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    print(theMap)

    println("Entries: " + theMap.entries)
    println("Keys:" + theMap.keys)
    println("Values:" + theMap.values)

    println(theMap.toString())

    val itr = theMap.keys.iterator()
    while (itr.hasNext()) {
        val key = itr.next()
        val value = theMap[key]
        println("${key}=$value")
    }

    println("Size of the Map " + theMap.size)
    println("Size of the Map " + theMap.count())

    val theKeyList = listOf("one", "four")
    val resultMap = theMap - theKeyList

    println(resultMap)
}