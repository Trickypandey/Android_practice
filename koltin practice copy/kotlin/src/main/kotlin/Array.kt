fun main(){
// creating array
    val a = 1..12
    val row=5;
    val arr= arrayOf("mango","apple","banana",3)

    // accesssing element linewise
    println(arr[0])
    println(arr[1])
    println(arr[2])
    println(arr[3])

    // accessing with forloop and name
    for (item in arr ){
        println(item)
    }

        // accessing element with index
    for (i in arr.indices){
//        println(arr[i])
        println(i)
    }
    // number range

    for (i in a){
        println(i)
    }

    // string array
    var text = "tricky"
    for (i in text){
        println(i)
    }

    // ACCESSING WITH INDEX

    for (item in text.indices step 2){
        print(text[item])
    }
// pyramid
    for(i in 1..row){
        for (j in 1..i){
            print("*")
        }
        println()
    }
    // reverse pyramid
    for(i in row downTo 1){
        for (j in 1..i){
            print("*")
        }
        println()
    }
}