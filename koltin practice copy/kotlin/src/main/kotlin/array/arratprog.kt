package array
class temp{
    val name:String=""
    var index:Int=0
    var salary:Int =10000


}

fun main() {
    var arr = intArrayOf(1,7,2,3,6,5,4)
    var arr1 = intArrayOf(10,13,11,15,12)
    var strArr = arrayOf<String>("Ajay","Prakesh","Michel","John","Sumit")
    // searching in array
    var search :Int = 5
    for (j in arr.indices){
        if (search==arr[j]){
            println("found ${arr[j]} and $search and $j")
        }
        else{
            println("not found ${arr[j]} and $search and $j")
        }
    }
    for (i in arr.indices){
        print("${arr[i]},")
    }
println()
    // swap in array manual
    var temp =arr[1]
    arr[1]=arr[4]
    arr[4]=temp

    for (i in arr.indices){
        print("${arr[i]},")
    }

    // swap inbuld funtion
println()
    arr[3] = arr[5].also { arr[5] = arr[3] }
    for (i in arr.indices){
        print("${arr[i]},")
    }

    // string arr sort
    strArr.sort()
    println()
    for (i in strArr.indices){
        print("${strArr[i]},")
    }
    // merge two array
    println()
    var mergedarr = arr.plus(arr1)
    for (i in mergedarr.indices){
        print("${mergedarr[i]},")
    }
    // merge arr
    val length = arr.size +arr1.size
    val resArr = IntArray(length)
    var pos=0
    for (element in arr){
        println(element)
        resArr[pos] = element
        pos++
    }
    for (element in arr1){
        println(element)
        resArr[pos] = element
        pos++
    }
    for (i in resArr){
        print(i)
    }

    resArr.sort()

    for (i in resArr){
        print("${i},")
    }


}


