package class_obj

open class Outer {
    private val a = 1
    protected open val b = 2
    internal open val c = 3
    val d = 4  // public by default

    protected class Nested {
        public val e: Int = 5
    }
    public class Nested1 {
        public val e: Int = 5
    }
}

class Subclass : Outer() {
    // a is not visible
    // b, c and d are visible
    // Nested and e are visible

    override val b = 5   // 'b' is protected
    override val c = 7   // 'c' is internal
}

fun main() {
    var outer = Outer()
    var nested = Outer.Nested1()
    // inner class member
    println(nested.e)
//    var nested = Outer.Nested() won't get work cause nested is protected
//    println(outer.a)  this won't get print
//    println(outer.b)  this won't get print
    println(outer.c)
    println(outer.d)
//    println(outer.)

    println("Sub Class")

    var sub = Subclass()
    println(sub.c)
//    println(sub.b)  won't print
}

