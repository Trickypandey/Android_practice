package class_obj

fun main() {
//    findarea(arrayOf(Circle(10.0),Square(5.0),Triangle(2.0,10.0)))


    // type checking
   val circle = Circle(20.0)
    val player = Player("tricky")
    val arr = arrayOf(circle,player)
    for (obj in arr){
        if (obj is Circle){
            println( obj.area())
        }
    }
}
fun dragObject(objects: Array<draggeble>){
    for (obj in objects){
        obj.drag()
    }
}
interface draggeble{
    fun drag()
}
fun findarea(objects: Array<shape>){
    for (obj in objects){
        println("area  = ${obj.area()}")
    }
}
abstract class shape : draggeble{
    abstract fun area():Double
//    abstract fun drag()
}

class Circle(val radius : Double):shape(){
    override fun area():Double = Math.PI * radius * radius

    override fun drag() {
        println("Circle is dragging")
    }
}

class Square(val side:Double):shape(){
    override fun area(): Double {
        return side*side
    }

    override fun drag() {
        println("square is dragging")
    }
}
class  Triangle (val base : Double, val height :Double):shape(){
    override fun area(): Double {
        return 0.5*height*base
    }

    override fun drag() {
        println("Triangle is dragging")
    }
}

class Player(val name : String) : draggeble{
    override fun drag() = println("$name is dragging")
}