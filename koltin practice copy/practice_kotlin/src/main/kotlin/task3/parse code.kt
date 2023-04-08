package task3
fun parseCode(string: String) {
    var temp= mutableListOf<Any>()
    string.split("0").forEach{
        it.split(" ").forEach{
            if (it != ""){
                temp.add(it)
            }
        }
    }
    println(temp)
}
fun main() {
    parseCode("Sourabh0000Pandey00000123123")
    parseCode("thomas0000000000000sdnfkrbbalblrga000000000000000000012314132413")
}