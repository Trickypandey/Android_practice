open class Rectangle {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"

    val size : Int get()=67
}

class FilledRectangle : Rectangle() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor

    var fillsize :Int=0
        get() = field
        set(value) {
            field=value
        }
}
fun main(){
    val temp=FilledRectangle()
    temp.draw()
    temp.fillsize=541
    println(temp.fillColor)
    println(temp.fillsize)
}