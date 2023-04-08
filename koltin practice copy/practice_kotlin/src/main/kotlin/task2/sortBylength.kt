package task2
fun sortBYLength(str:String) {
    var temp: String = ""
    str.split(" ").sorted().forEach {
        temp += it
    }
}
fun main() {
var text = "my name is sourabh"
    sortBYLength(text)
}