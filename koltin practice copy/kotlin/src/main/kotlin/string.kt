fun main(){
    var sourabh="my name is sourabh"
    var tricky="my name is tricky"
    // finding length
    println(sourabh.length + tricky.length)
    println("the length of the string is " + sourabh.length)

    // convert to uppercase
    println(tricky.toUpperCase())

    // Convert to lower
    println(tricky.toLowerCase())

    // get character at that index
    println(sourabh.getOrNull(1))
    println(tricky.getOrNull(100))
    var stringhh="hello this line is written in kotlin"
    var rawString = """This is going to be a multi-line string and will not have any escape sequence""";
    println(rawString)
    println(stringhh)
    println("Full Name :" + sourabh + tricky)

    println("Full Name with plus:" + sourabh.plus(tricky) )

}