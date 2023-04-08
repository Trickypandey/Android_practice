package list

fun main() {
    val theList = listOf("one", "two",null, "three", "four")
    val theList1 = listOf(10, 20, 30, 31, 40, 50, -1, 0)
    println(theList)
// using list Iterator
    val itr = theList.listIterator()
    while (itr.hasNext()) {
        println(itr.next())
    }

    // using for loop
    for (i in theList.indices){
        println(theList[i])
    }

    // using foreach
    theList.forEach { println(it) }

    // size of the list
    println("Size of the List ${theList.size}")

    // element in a list
    if ("three" in theList){
        println(true)
    }else{
        println(false)
    }

    // using cantain method
    if(theList.contains("two")){
        println(true)
    }else{
        println(false)
    }

    //is empty
    if(theList.isEmpty()){
        println(true)
    }else{
        println(false)
    }

     // indexof method
    println("Index of 'two':" + theList.indexOf("three"))

    //get method
    println("Element on third position :" + theList.get(3))

    // remove null from list
    val resultList = theList.filterNotNull()
    println(resultList)

    // filter
    val result = theList1.filter { it > 10}
    println(result)

    // sub list
    val temp = theList.subList(2,4)
    println(temp.toString())

    // reversed lsit
//    val revList =
    println("this for reverse list"+theList.asReversed())
//    println(resultList)

    // associate

    val listc=theList.union(theList1)

    println(listc)
}