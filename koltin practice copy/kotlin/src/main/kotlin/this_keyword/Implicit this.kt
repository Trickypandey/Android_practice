package this_keyword

fun main() {
    fun display(){
        println("hello i'  top level display funtion")
    }
    fun printLine() { println("Top-level function") }

    class A {
        fun printLine() { println("Member function") }

        fun invokePrintLine(omitThis: Boolean = false)  {
            if (omitThis) printLine()
            else display()
        }
    }

    A().invokePrintLine() // Member function
    A().invokePrintLine(omitThis = true) // Top-level function
    A().invokePrintLine(omitThis = false) // Member function

}